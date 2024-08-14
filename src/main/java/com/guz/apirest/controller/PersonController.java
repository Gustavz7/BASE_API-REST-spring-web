package com.guz.apirest.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.guz.apirest.model.entity.Person;
import com.guz.apirest.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;

	@GetMapping("getAll")
	public ResponseEntity<List<Person>> getAllPersons() {
		return ResponseEntity.ok(personService.getAllPersons());
	}

	@GetMapping("get")
	public ResponseEntity<Person> getPerson(@RequestParam("id") Integer id) {
		Optional<Person> person = personService.searchPerson(id);
		return ResponseEntity.ok().body(person.isPresent() ? person.get() : new Person());
	}

	@PostMapping("/create")
	public ResponseEntity<String> createPerson(@RequestBody Person person) {
		return ResponseEntity.ok().body("Create status: " + personService.createPerson(person));
	}
	
	@PostMapping("/update")
	public ResponseEntity<String> updatePerson(@RequestBody Person person) {
		return ResponseEntity.ok().body("Update status: " + personService.updatePerson(person));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deletePerson(@RequestParam("id") Integer id) {
		return ResponseEntity.ok().body("Delete status: " + personService.deletePerson(id));
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deletePerson() {
		return ResponseEntity.ok().body("Delete status: " + personService.deleteAll());
	}

}
