package kr.kyung.spring.item.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import kr.kyung.spring.item.contant.ItemSellStatus;
import kr.kyung.spring.item.dto.ItemFormDto;
import kr.kyung.spring.utils.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "item")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "item_id")
	private Long id;
	@Column(nullable = false , length = 50)
	private String itemNm;
	@Column(nullable = false)
	private int price;
	@Column(nullable = false, name = "number")
	private int stockNumber;
	
	@Enumerated(EnumType.STRING)
	private ItemSellStatus itemSellStatus;
	
	
	@Lob
	@Column(nullable = false)
	private String itemDetail;

    public void updateItem(ItemFormDto itemFormDto){
        this.itemNm = itemFormDto.getItemNm();
        this.price = itemFormDto.getPrice();
        this.stockNumber = itemFormDto.getStockNumber();
        this.itemDetail = itemFormDto.getItemDetail();
        this.itemSellStatus = itemFormDto.getItemSellStatus();
    }
	
	
	
	

}
