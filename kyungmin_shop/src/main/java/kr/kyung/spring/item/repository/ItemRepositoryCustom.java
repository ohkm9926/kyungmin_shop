package kr.kyung.spring.item.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.kyung.spring.item.dto.ItemSearchDto;
import kr.kyung.spring.item.entity.Item;

public interface ItemRepositoryCustom {
   Page<Item> getAdminItemPage(ItemSearchDto itemSearchDto, Pageable pageable);
	   
   
}
