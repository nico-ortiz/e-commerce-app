package com.project.ecommerce;

import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}

	@GetMapping("/api/person")
	public List<Person> getPerson() {
		return List.of(
			new Person(1L,
					"Devin Booker",
					"123456789",
					"dbook")
		);
	}
}
