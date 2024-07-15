package kr.kyung.spring.item.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import kr.kyung.spring.utils.entity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ItemImg extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "item_img_id")
	private Long id;
	
	private String imgName;
	
	private String oriImgname;
	
	private String imgUrl;
	
	private String repImgYn;
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "item_id")
	private Item item;


	public void updateItemImg(String oriImgname,String imgName, String imgUrl) {
		
		this.imgName = imgName;
		this.oriImgname = oriImgname;
		this.imgUrl = imgUrl;
	}
	
	
	
	

}
