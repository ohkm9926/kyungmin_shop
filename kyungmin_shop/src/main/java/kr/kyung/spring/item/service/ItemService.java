package kr.kyung.spring.item.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.EntityNotFoundException;
import kr.kyung.spring.item.dto.ItemFormDto;
import kr.kyung.spring.item.dto.ItemImgDto;
import kr.kyung.spring.item.dto.ItemSearchDto;
import kr.kyung.spring.item.entity.Item;
import kr.kyung.spring.item.entity.ItemImg;
import kr.kyung.spring.item.repository.ItemImgRepository;
import kr.kyung.spring.item.repository.ItemRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class ItemService {
	
	private final ItemImgRepository itemImgRepository;
	private final ItemRepository itemRepository;
	private final itemImgService itemImgService;
	
	public Long saveItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws IOException {
		
		Item item = itemFormDto.createItem();
		itemRepository.save(item);
		
		for (int i = 0; i < itemImgFileList.size(); i++) {
			ItemImg itemImg = new  ItemImg();
			itemImg.setItem(item);
			if (i ==0) {
				itemImg.setRepImgYn("Y");
				
			}else {
				itemImg.setRepImgYn("N");
			}
			itemImgService.saveItemImg(itemImg, itemImgFileList.get(i));
			
		}
		
		return item.getId();
		
	}
	
	public ItemFormDto getItemDetail(Long itemId) {
		List<ItemImg> itemImgList = itemImgRepository.findByItemIdOrderByIdAsc(itemId);
		List<ItemImgDto> itemImgDtoList = new ArrayList<>();
		
		for (ItemImg itemImg : itemImgList) {
			ItemImgDto itemImgDto = ItemImgDto.of(itemImg);
			
			itemImgDtoList.add(itemImgDto);
			
		}
		
		Item item = itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);
		
		ItemFormDto itemFormDto = ItemFormDto.of(item);
		itemFormDto.setItemImgDtoList(itemImgDtoList);
		
		return itemFormDto;
		
		
	}
	
	public Long updateItem(ItemFormDto itemFormDto, List<MultipartFile> itemImgFileList) throws IOException {
		
		Item item = itemRepository.findById(itemFormDto.getId()).orElseThrow(EntityNotFoundException::new);
		
		item.updateItem(itemFormDto);
		
		List<Long> itemImgIds = itemFormDto.getItemImgIds();
		for (int i = 0; i < itemImgFileList.size(); i++) {
			itemImgService.updateItemImg(itemImgIds.get(i), itemImgFileList.get(i));
			
		}
		
		return item.getId();
		
	}
	
	public Page<Item> getAdmininItemPage(ItemSearchDto itemSearchDto , Pageable pageable) {
		
		return itemRepository.getAdminItemPage(itemSearchDto, pageable);
		
	}

}
