package com.codingdojo.License.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.License.models.Person;
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
//	List<Person> findAll();

	List<Person> findAll();

}
