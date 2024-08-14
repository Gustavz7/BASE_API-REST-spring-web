package com.guz.apirest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.guz.apirest.model.entity.Person;
import com.guz.apirest.repository.PersonRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PersonService {

	private final PersonRepository personRepository;

	public boolean createPerson(Person person) {
		return this.personRepository.save(person) != null;
	}

	public Optional<Person> searchPerson(Integer personId) {
		return this.personRepository.findById(personId);
	}

	public boolean updatePerson(Person person) {
		return this.personRepository.save(person) != null;
	}

	public boolean deletePerson(Integer personId) {
		this.personRepository.deleteById(personId);
		return !this.searchPerson(personId).isPresent();
	}

	public List<Person> getAllPersons() {
		return this.personRepository.findAll();
	}

	public boolean deleteAll() {
		this.personRepository.deleteAll();
		return this.getAllPersons().isEmpty();
	}

}
