package com.devisis.course.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devisis.course.entites.OrderItem;


@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{
	

}
