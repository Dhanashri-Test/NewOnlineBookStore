package com.online.bookstore.demo.services;

import com.online.bookstore.demo.entity.Book;
import com.online.bookstore.demo.exception.ResourceNotFoundException;
import com.online.bookstore.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookRepository bookRepository;
    @Override
    public Set<Book> getAllBooks() {

        Set<Book> books= new HashSet<>();//= (Set<Book>) bookRepository.findAll();
        books.addAll(bookRepository.findAll());
        return books;
    }

    @Override
    public Book getBooksById(Integer id) {
        Book book=bookRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Book","Book ID",id));
        return book;
    }

    @Override
    public Set<Book> searchBooks(String search) {
        return null;
    }

    @Override
    public Book updateBook(Book book,Integer id) {

        Book oldBook=bookRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Book","Book ID",id));
        oldBook.setPrice(book.getPrice());
        oldBook.setQuantity(book.getQuantity());
        oldBook.setBookDetail(book.getBookDetail());
        return bookRepository.save(oldBook);
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void removeBook(Integer bookId) {
        Book book= bookRepository.findById(bookId).orElseThrow(()->new ResourceNotFoundException("Book","Book ID",bookId));
        bookRepository.delete(book);
    }
}
