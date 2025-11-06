package com.practice.controller;

import com.practice.pojo.Book;
import com.practice.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookRepo bookRepo;

    @PostMapping("/saveBook")
    public String saveBook(@RequestBody Book book){
        bookRepo.save(book);

        return "Book saved successfully";
    }

    @GetMapping("/getBooks")
    public List<Book> getBooks(){
        return bookRepo.findAll();
    }

    @DeleteMapping("/deleteBook/{title}")
    public String deleteBook(@PathVariable String title){
        bookRepo.deleteByTitle(title);
        return "Book deleted successfully";
    }
}
