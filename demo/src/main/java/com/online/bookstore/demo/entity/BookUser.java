package com.online.bookstore.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="book_user")
@IdClass(BookUserId.class)
public class BookUser {

    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="book_id", referencedColumnName="id")
    private Book book;
    @Id
    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name="customer_id", referencedColumnName="username")
    private Customer customer;

    public BookUser() {
    }

    public BookUser(Book book, Customer customer) {
        this.book = book;
        this.customer = customer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
