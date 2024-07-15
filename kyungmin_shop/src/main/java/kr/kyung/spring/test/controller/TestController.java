package kr.kyung.spring.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import kr.kyung.spring.test.dto.TestDto;
@RestController
public class TestController {
	@GetMapping("/hello")
	public String hello() {
		return "Hello World";
	}
	
	@GetMapping("/test")
  public TestDto test() {
	  TestDto dto = new TestDto();
	  dto.setAge(10);
	  dto.setName("홍길동");
	  return dto;
	  
  }
}
