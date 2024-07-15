package kr.kyung.spring.item.dto;

import kr.kyung.spring.item.contant.ItemSellStatus;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class ItemSearchDto {
	
	 private String searchDateType;

	    private ItemSellStatus searchSellStatus;

	    private String searchBy;

	    private String searchQuery = "";


}
