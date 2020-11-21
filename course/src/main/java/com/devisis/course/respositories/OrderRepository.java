package com.devisis.course.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devisis.course.entites.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	

}
