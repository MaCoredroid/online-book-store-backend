package com.macoredroid.onlinebookstore.entity;
import com.fasterxml.jackson.annotation.*;
import jdk.jfr.Unsigned;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "booklist", schema = "test", catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "booklistID")
public class Booklist {
    private int booklistID;
    private String name;
    private String author;
    private Double price;
    private String isbn;
    private int stock;
    
    @Id
    @Column(name = "booklistID")
    @GeneratedValue(strategy = IDENTITY)
    public int getBooklistID() { return booklistID; }

    public void setBooklistID(int booklistID) { this.booklistID=booklistID; }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "author")
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Basic
    @Column(name = "price")
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price =price;
    }

    @Basic
    @Column(name = "isbn")
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Basic
    @Column(name = "stock")
    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock =stock;
    }

}


