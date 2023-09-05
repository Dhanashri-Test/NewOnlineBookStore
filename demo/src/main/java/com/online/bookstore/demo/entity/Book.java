package com.online.bookstore.demo.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Table(name="book")
public class Book {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @JoinColumn(name="id", referencedColumnName="id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(value= FetchMode.SELECT)
    private BookDetails bookDetail;
    @Column(name = "price")
    private double price;
    @Column(name = "quantity")
    private int quantity;

    @ManyToMany(fetch=FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST,
            CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name="book_user", joinColumns = @JoinColumn(name="book_id"),
            inverseJoinColumns = @JoinColumn(name="customer_id"))
    private List<Customer> customers;

    @OneToMany(mappedBy="book", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.PERSIST,
			CascadeType.MERGE, CascadeType.REFRESH})
   // @JsonManagedReference
	private List<ShoppingCart> shoppingCart;
    public Book() {
    }

    public Book(int id, String name, BookDetails details, double price, int quantity) {
        this.id = id;
        this.name = name;
        this.bookDetail = details;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookDetails getBookDetail() {
        return bookDetail;
    }

    public void setBookDetail(BookDetails bookDetail) {
        this.bookDetail = bookDetail;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
    public List<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<ShoppingCart> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", bookDetail="
                + bookDetail + "]";
    }
}