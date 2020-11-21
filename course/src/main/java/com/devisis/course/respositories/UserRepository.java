package com.devisis.course.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devisis.course.entites.User;

public interface UserRepository extends JpaRepository<User, Long>{
	

}
