package com.online.bookstore.demo.services;

import com.online.bookstore.demo.entity.Book;
import io.swagger.models.auth.In;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface BookService {

    public Set<Book> getAllBooks();

    public Book getBooksById(Integer id);

    public Set<Book> searchBooks(String search);

    public Book updateBook(Book book,Integer id);

    public Book addBook(Book book);

    public void removeBook(Integer bookId);


}
