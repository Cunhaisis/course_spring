package com.devisis.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devisis.course.entites.Category;
import com.devisis.course.entites.Order;
import com.devisis.course.entites.User;
import com.devisis.course.entites.enums.OrderStatus;
import com.devisis.course.respositories.CategoryRepository;
import com.devisis.course.respositories.OrderRepository;
import com.devisis.course.respositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		User u3 = new User(null, "Dean Winchester", "dean@fantasminha.com", "988888888", "123456");
		User u4 = new User(null, "Sam Winchester", "sammy@fantasminha.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u3);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u4);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u3);

		userRepository.saveAll(Arrays.asList(u3, u4));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

	}

}
