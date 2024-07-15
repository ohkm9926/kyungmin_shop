package kr.kyung.spring.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.kyung.spring.order.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
	

}
