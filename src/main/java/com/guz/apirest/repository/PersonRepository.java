package com.guz.apirest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.guz.apirest.model.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	public Optional<List<Person>> findByNameAndEmail(String name, String email);
	
	
}
