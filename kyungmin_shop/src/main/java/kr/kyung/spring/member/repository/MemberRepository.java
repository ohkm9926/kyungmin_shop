package kr.kyung.spring.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.kyung.spring.member.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
	
     Member findByEmail(String email);	
}
