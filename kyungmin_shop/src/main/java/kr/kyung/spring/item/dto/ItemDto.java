package kr.kyung.spring.item.dto;

import java.time.LocalDateTime;

import kr.kyung.spring.utils.entity.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ItemDto extends  BaseEntity{
	
	private Long id;			// 상품 코드 
	
	private String itemNm;		// 상품 이름
	
	private int price;			// 상품 가격
	
	private int stockNumber;	// 재고 수량
	
	private String itemSellStatus;
	
	private String itemDetail;	// 상품 상세 설명 
	
	
}