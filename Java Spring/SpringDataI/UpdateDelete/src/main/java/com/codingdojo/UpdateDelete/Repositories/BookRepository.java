package com.codingdojo.UpdateDelete.Repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.UpdateDelete.models.Book;

import antlr.collections.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
	List<Book> findByDescriptionContaining(String search);
	List<Book> countByTitleContaining(String search);
	List<Book> deleteByTitleStartingWith(String search);
}
