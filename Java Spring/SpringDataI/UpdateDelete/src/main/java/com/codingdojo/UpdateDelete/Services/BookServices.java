package com.codingdojo.UpdateDelete.Services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.UpdateDelete.Repositories.BookRepository;
import com.codingdojo.UpdateDelete.models.Book;

@Service
public class BookServices {
	private final BookServices bookRepository ;
    
	public BookServices(BookRepository bookRepository) {
		this.bookRepository=bookRepository;
	}
	public List<Book> allBooks(){
		return bookRepository.findAll();
	}
	public Book createBook(Book b) {
        return bookRepository.save(b);
	}
	public Book findBook(Long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
    }
	public Book updateBook(Long id, String title, String desc, String lang, int numOfPages) {
		Book myBook=findBook(id);
		myBook.setTitle(title);
		myBook.setDescription(desc);
		myBook.setLanguage(lang);
		myBook.setNumberOfPages(numOfPages);
		return bookRepository.save(myBook);
	}
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}
