package com.practice.repository;

import com.practice.pojo.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo extends MongoRepository<Book, String> {
    void deleteByTitle(String title);
}
