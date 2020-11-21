package com.devisis.course.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devisis.course.entites.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	

}
