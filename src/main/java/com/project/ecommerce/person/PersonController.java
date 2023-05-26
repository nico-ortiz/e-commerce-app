package com.project.ecommerce.person;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api/v1/person")
public class PersonController {
    
    private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	@GetMapping()
	public List<Person> getPerson() {
		return personService.getPerson();
	}
	
}
