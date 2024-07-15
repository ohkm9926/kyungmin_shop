package kr.kyung.spring.item.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import kr.kyung.spring.item.contant.ItemSellStatus;
import kr.kyung.spring.item.entity.Item;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemFormDto {
	
private Long id;			// 상품 코드 
	
    @NotBlank(message = "상품명은 필수 항목입니다 ")
	private String itemNm;		// 상품 이름
    @jakarta.validation.constraints.NotNull(message = "가격은 필수 항목 입니다.")
	private int price;			// 상품 가격
    @jakarta.validation.constraints.NotNull(message = "재고는 필수 항목 입니다.")
	private int stockNumber;	// 재고 수량
	
    private ItemSellStatus itemSellStatus;
	
	@NotBlank(message = "상품설명은 필수 항목입니다 ")
	private String itemDetail;	// 상품 상세 설명 
	
	private List<ItemImgDto> itemImgDtoList = new ArrayList<>();
	
	private List<Long> itemImgIds  = new ArrayList<>();
	
	private static ModelMapper modelMapper = new ModelMapper();
	
	public Item createItem() {
		return modelMapper.map(this, Item.class);
	}
	
	public static ItemFormDto of(Item item) {
		return modelMapper.map(item, ItemFormDto.class);
	}

}
