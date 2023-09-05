package com.online.bookstore.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "book_details")
public class BookDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type;
    private String detail;
    private int sold;

    public BookDetails() {
    }

    public BookDetails(int id, String type, String detail, int sold) {
        this.id = id;
        this.type = type;
        this.detail = detail;
        this.sold = sold;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "BookDetails{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", detail='" + detail + '\'' +
                ", sold=" + sold +
                '}';
    }
}
