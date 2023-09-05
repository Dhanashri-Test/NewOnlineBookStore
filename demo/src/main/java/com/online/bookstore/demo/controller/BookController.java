package com.online.bookstore.demo.controller;

import com.online.bookstore.demo.entity.Book;
import com.online.bookstore.demo.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.HtmlEscapeTag;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public ResponseEntity<Set<Book>> getAllBooks()
    {
        Set<Book> books=bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookByID(@PathVariable("id") Integer id)
    {
        Book book=bookService.getBooksById(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }


    @PostMapping()
    public ResponseEntity<Book> addBooks(@RequestBody Book book)
    {
        Book book1=bookService.addBook(book);
        return new ResponseEntity<>(book1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBooks(@PathVariable("id") Integer id)
    {
        bookService.removeBook(id);
        return new ResponseEntity<>("book deleted Successfully", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBooks(@RequestBody Book book,@PathVariable("id") Integer id)
    {
        Book book1=bookService.updateBook(book,id);
        return new ResponseEntity<>(book1, HttpStatus.OK);
    }
}
