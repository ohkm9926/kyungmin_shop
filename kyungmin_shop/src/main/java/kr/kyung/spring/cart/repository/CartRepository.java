package kr.kyung.spring.cart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.kyung.spring.cart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	

}
