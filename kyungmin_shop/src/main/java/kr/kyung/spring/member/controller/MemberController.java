package kr.kyung.spring.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import groovy.beans.Bindable;
import jakarta.validation.Valid;
import kr.kyung.spring.member.dto.MemberFormDto;
import kr.kyung.spring.member.entity.Member;
import kr.kyung.spring.member.repository.MemberRepository;
import kr.kyung.spring.member.service.MemberService;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;

@Controller
@RequestMapping("/member")
@Log4j2
public class MemberController {

	@Autowired
	MemberService memberService;

	@Autowired
	PasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String login() {
		return "member/memberLogin";

	}

	@GetMapping("/new")
	public String memberForm(Model model) {

		model.addAttribute("memberFormDto", new MemberFormDto());
		return "member/memberForm";

	}

	@PostMapping("/new")
	public String memberForm(@Valid MemberFormDto memberFormDto, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			return "member/memberForm";
		}

		try {
			Member member = Member.createMember(memberFormDto, passwordEncoder);
			memberService.saveMember(member);
		} catch (IllegalStateException e) {
			model.addAttribute("errorMessage", e.getMessage());
			return "member/memberForm";
		}
		return "redirect:/";
	}

	@GetMapping("/login/error")
	public String loginError(Model model) {
		model.addAttribute("loginErrorMsg", "아이디 또는 패스워드가 잘못되었습니다.");
		return "member/memberLogin";
	}

}
