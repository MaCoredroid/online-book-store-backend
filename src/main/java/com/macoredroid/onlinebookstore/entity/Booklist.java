package com.macoredroid.onlinebookstore.entity;
import com.fasterxml.jackson.annotation.*;


import javax.persistence.*;
import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Booklist that = (Booklist) o;

        if (booklistID != that.booklistID) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(price, that.price)) return false;
        if (!Objects.equals(isbn, that.isbn)) return false;
        if (!Objects.equals(stock, that.stock)) return false;



        return true;
    }

    @Override
    public int hashCode() {
        int result = booklistID;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + stock;
        return result;
    }





}


