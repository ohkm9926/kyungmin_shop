package kr.kyung.spring.thymeleaf.controller;

import java.awt.Point;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.kyung.spring.item.dto.ItemDto;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/thymeleaf")
public class ThymeleafController {
	@GetMapping("/ex1")
	public String ex1(Model model) {
		Point p = new Point(10, 20);

		model.addAttribute("data", p);

		return "thymeleaf/ex1";
	}

	@GetMapping("/ex2")
	public String ex2(Model model) {
		ItemDto itemDto = new ItemDto();
		itemDto.setItemDetail("상품상세설명");
		itemDto.setItemNm("테스트상품 01");
		itemDto.setPrice(10000);
		

		model.addAttribute("itemDto", itemDto);

		return "thymeleaf/ex2";
	}

	@GetMapping({"/ex3","/ex4"})
	public void ex3(Model model) {

		List<ItemDto> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			ItemDto itemDto = new ItemDto();
			itemDto.setItemDetail("상품상세설명" + i);
			itemDto.setItemNm("테스트상품" + i);
			itemDto.setPrice(10000 * i);
			
			list.add(itemDto);
		}
		model.addAttribute("List", list);
	    

		
	}
	@GetMapping("/ex5")
	public String ex5(String param1,String param2 ,Model model) {
		log.info("===========>" + param1 + "," + param2);
		model.addAttribute("param1" , param1);
		model.addAttribute("param2" , param2);
		
		
		
		return "thymeleaf/ex5";
	}
	
	@GetMapping({"/ex6","/ex7"})
	public void ex6() {
	
		
		
		
	}
}
