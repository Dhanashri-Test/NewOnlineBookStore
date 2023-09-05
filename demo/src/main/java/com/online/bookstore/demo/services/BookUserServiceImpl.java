package com.online.bookstore.demo.services;

import com.online.bookstore.demo.entity.Book;
import com.online.bookstore.demo.entity.Customer;
import com.online.bookstore.demo.exception.ResourceNotFoundException;
import com.online.bookstore.demo.repository.BookRepository;
import com.online.bookstore.demo.repository.BookUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class BookUserServiceImpl implements BookUserService {

    @Autowired
    private BookUserRepository bookUserRepos;

    @Autowired
    private BookRepository bookRepos;

    @Override
    @Transactional
    public Set<Book> getBooksPurchasedBy(Customer customer) {

        Set<Integer> bookIds = bookUserRepos.getPurchasedBooks(customer.getUsername());

        Set<Book> books = new HashSet<Book>();

        for(int id : bookIds) {
            Book book = bookRepos.findById(id).orElseThrow(()->new ResourceNotFoundException("Book","Book ID",id));
            if(book != null) {
                books.add(book);
            }
        }
        customer.setBooks(books);

        return books;
    }

}
