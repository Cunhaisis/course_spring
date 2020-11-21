package com.devisis.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devisis.course.entites.User;
import com.devisis.course.respositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u3 = new User(null, "Dean Winchester", "dean@fantasminha.com", "988888888", "123456");
		User u4 = new User(null, "Sam Winchester", "sammy@fantasminha.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u3, u4));

	}

}
