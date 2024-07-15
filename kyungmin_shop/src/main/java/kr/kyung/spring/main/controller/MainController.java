package kr.kyung.spring.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.persistence.GeneratedValue;

@Controller
public class MainController {
	@GetMapping("/")
	public String main() {
		return "main";
	}
	

}
