package kr.kyung.spring.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.kyung.spring.order.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	

}
