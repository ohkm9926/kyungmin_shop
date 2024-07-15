package kr.kyung.spring.test.entity;

import org.apache.el.parser.AstFalse;
import org.hibernate.annotations.Cache;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Test {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	@Column(name="name" , nullable = false ,length = 20)
	private String Myname;
	private int myage;
	private String myinfo;
	

}
