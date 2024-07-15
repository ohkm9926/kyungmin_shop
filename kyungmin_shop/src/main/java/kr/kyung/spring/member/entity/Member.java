package kr.kyung.spring.member.entity;

import org.springframework.security.crypto.password.PasswordEncoder;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import kr.kyung.spring.member.constant.Role;
import kr.kyung.spring.member.dto.MemberFormDto;
import kr.kyung.spring.utils.entity.BaseEntity;
import kr.kyung.spring.utils.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;
	
	
	private String name;
	
	@Column(unique = true)
	private String email;
	private String password;
	private String address;
	
	
	@Enumerated(EnumType.STRING)
	private Role role;
	
	public static Member createMember(MemberFormDto memberFormDto,PasswordEncoder passwordEncoder) {
		
		Member member = new Member();
		member.setName(memberFormDto.getName());
		member.setEmail(memberFormDto.getEmail());
		member.setAddress(memberFormDto.getAddress());
		member.setRole(Role.ADMIN);
		String password = passwordEncoder.encode(memberFormDto.getPassword()) ;
		member.setPassword(password);
	
		return member;
	
		
	}
	
	

}
