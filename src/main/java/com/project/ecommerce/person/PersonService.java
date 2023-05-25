package com.project.ecommerce.person;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonService {

    //Lo que devuelve debe venir de la base de datos
    public List<Person> getPerson() {
		return List.of(
			new Person(1L,
					"Devin Booker",
					"123456789",
					"dbook")
		);
	}
}
