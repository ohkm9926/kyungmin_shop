package kr.kyung.spring.item.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.kyung.spring.item.entity.ItemImg;

public interface ItemImgRepository extends JpaRepository<ItemImg, Long> {

  List<ItemImg> findByItemIdOrderByIdAsc(Long itemId);
	
   
}
