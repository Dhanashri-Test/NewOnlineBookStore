package com.online.bookstore.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customers")

public class Customer {

    @Id
    @Column(name="username")
    private String username;
    @Column(name="first_name")
    private String Fname;
    @Column(name="last_name")
    private String Lname;
    @Column(name="mob")
    private Long Mobile;
    @Column(name="email")
    private String email;
    @Column(name="address")
    private String address;

    @JoinColumn(name = "user_name", referencedColumnName = "username")
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
            //cascade ={ CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.MERGE})
    @JsonIgnore
    private User user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name="book_user", joinColumns=@JoinColumn(name="customer_id"),
            inverseJoinColumns=@JoinColumn(name="book_id"))
    private Set<Book> books;

    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval= true)
    //@JsonManagedReference
    private Set<ShoppingCart> shoppingCart;

    @OneToMany(mappedBy = "customer",fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<PurchaseHistory> purchaseHistories;

    public Customer() {
    }

    public Customer(String username, String fname, String lname, Long mobile, String email, String address, User user, Set<Book> books) {
        this.username = username;
        this.Fname = fname;
        this.Lname = lname;
        this.Mobile = mobile;
        this.email = email;
        this.address = address;
        this.user = user;
        this.books = books;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public Long getMobile() {
        return Mobile;
    }

    public void setMobile(Long mobile) {
        Mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<ShoppingCart> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(Set<ShoppingCart> shoppingCart) {
        this.shoppingCart.clear();
        if(shoppingCart != null)
            this.shoppingCart.addAll(shoppingCart);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", Fname='" + Fname + '\'' +
                ", Lname='" + Lname + '\'' +
                ", Mobile=" + Mobile +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", user=" + user +
                ", books=" + books +
                '}';
    }

    public void addShoppingCart(ShoppingCart shoppingCart) {
        if(this.shoppingCart == null)
            this.shoppingCart = new HashSet<ShoppingCart>();
        if(shoppingCart != null)
            this.shoppingCart.add(shoppingCart);
        //return this.shoppingCart;
    }

    public Set<PurchaseHistory> getPurchaseHistories() {
        return purchaseHistories;
    }

    public void setPurchaseHistories(Set<PurchaseHistory> purchaseHistories) {
        if(this.purchaseHistories == null)
            this.purchaseHistories = new HashSet<PurchaseHistory>();
        if(purchaseHistories != null)
            this.purchaseHistories.addAll(purchaseHistories);
    }

    public Set<PurchaseHistory> addPurchaseHistories(PurchaseHistory purchaseHistory) {
        if(this.purchaseHistories == null)
            this.purchaseHistories = new HashSet<PurchaseHistory>();
        if(purchaseHistory != null)
            this.purchaseHistories.add(purchaseHistory);
        return purchaseHistories;
    }
}
