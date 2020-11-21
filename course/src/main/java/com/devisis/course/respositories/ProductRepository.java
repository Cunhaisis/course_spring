package com.devisis.course.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devisis.course.entites.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	

}
