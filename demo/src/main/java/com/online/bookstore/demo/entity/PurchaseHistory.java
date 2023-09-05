package com.online.bookstore.demo.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name="purchase_history")
public class PurchaseHistory {

    @Id
    @Column(name="id")
    private String id;

    @JoinColumn(name="customer_id")
    @ManyToOne
    private Customer customer;

    @Column(name="date")
    private Date date;

    @OneToMany(mappedBy ="purchaseHistory", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<PurchaseDetail> purchaseDetails;

    public PurchaseHistory() {
    }

    public PurchaseHistory(String id, Date date) {
        this.id = id;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Set<PurchaseDetail> getPurchaseDetails() {
        return purchaseDetails;
    }

    public void setPurchaseDetails(Set<PurchaseDetail> purchaseDetails) {
        this.purchaseDetails = purchaseDetails;
    }

    @Override
    public String toString() {
        return "PurchaseHistory [id=" + id + ", customer=" + customer.getUsername() + ", date=" + date + ", purchaseDetails="
                + purchaseDetails + "]";
    }


}
