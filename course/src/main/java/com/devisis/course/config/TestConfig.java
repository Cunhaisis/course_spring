package com.devisis.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.devisis.course.entites.Category;
import com.devisis.course.entites.Order;
import com.devisis.course.entites.OrderItem;
import com.devisis.course.entites.Payment;
import com.devisis.course.entites.Product;
import com.devisis.course.entites.User;
import com.devisis.course.entites.enums.OrderStatus;
import com.devisis.course.respositories.CategoryRepository;
import com.devisis.course.respositories.OrderItemRepository;
import com.devisis.course.respositories.OrderRepository;
import com.devisis.course.respositories.ProductRepository;
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

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		Product p1 = new Product(null, "Notbook Lenovo Ideapad s145", "i7 16Gb", 4000.0, "");
		Product p2 = new Product(null, "Playstation 3", "Slin 500Gb.", 1000.0, "");
		Product p3 = new Product(null, "Xiaomi redmi 9s", "Celular da Xiaomi", 1550.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Diario dos Winchesters", "Cras fringilla convallis sem vel faucibus.", 100.99,
				"");

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

		p1.getCategories().add(cat3);
		p2.getCategories().add(cat1);
		p3.getCategories().add(cat1);
		p4.getCategories().add(cat1);
		p5.getCategories().add(cat2);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		User u3 = new User(null, "Dean Winchester", "dean@fantasminha.com", "988888888", "123456");
		User u4 = new User(null, "Sam Winchester", "sammy@fantasminha.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u3);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u4);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u3);

		userRepository.saveAll(Arrays.asList(u3, u4));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T19:53:07Z"), o1);
		o1.setPayment(pay1);

		orderRepository.saveAll(Arrays.asList(o1));

	}

}
