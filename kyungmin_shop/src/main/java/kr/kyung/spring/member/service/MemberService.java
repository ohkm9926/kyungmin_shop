package kr.kyung.spring.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import kr.kyung.spring.member.entity.Member;
import kr.kyung.spring.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements UserDetailsService {
     @Autowired
	private final MemberRepository memberRepository;
     
     public Member saveMember(Member member) {
    	 
    	 validateDuplicate(member);
    	return memberRepository.save(member);
     }

	private void validateDuplicate(Member member) {
		Member findMember = memberRepository.findByEmail(member.getEmail());
		if (findMember !=null) {
			throw new IllegalStateException("이미 등록된 사용자입니다.");
			
		}
		
	}

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmail(email);
		if (member ==null) {
			throw new UsernameNotFoundException("해당 사용자가 없습니다 loadUserByUsername ="+ email);
			
		}
		log.info("===============>" + member);
		
		return User.builder()
				.username(member.getEmail())
				.password(member.getPassword())
				.roles(member.getRole().toString())
				.build();
	}
     
}
