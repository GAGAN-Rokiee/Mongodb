package com.Gagan.Spring.mongo.api.resources;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Gagan.Spring.mongo.api.models.Book;
import com.Gagan.Spring.mongo.api.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository  bookRepository;
	
	private final static Logger logger =LoggerFactory.getLogger(BookController.class);
	
	@PostMapping("/addBook")
	private String  saveBook(@RequestBody Book book)
	{
	    logger.info("saveBook  data"+ book);
		bookRepository.save(book);
	    logger.info("Book saved with id "+ book.getId());
		return  "Book saved with id: " +book.getId();
	   
	}
	
	@GetMapping("findAllBooks")
	private List<Book> getBooks()
	{
		return bookRepository.findAll();
	}
	
	@GetMapping("findBookById/{id}")
	private Optional<Book> getBookById(@PathVariable int id)
	{
		return bookRepository.findById(id);
	}
	
	@DeleteMapping("delete/{id}")
	private String deleteBook(@PathVariable int id)
	{
		bookRepository.deleteById(id);
		return "book delete with id: " +id;
	}

}
