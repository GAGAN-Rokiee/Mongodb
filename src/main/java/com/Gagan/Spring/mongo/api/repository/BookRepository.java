package com.Gagan.Spring.mongo.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Gagan.Spring.mongo.api.models.Book;

public interface BookRepository  extends MongoRepository<Book, Integer> {
	

}
