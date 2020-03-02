package com.macoredroid.onlinebookstore.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
@Table(name = "booklist", schema = "test", catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "booklistID")
public class Booklist implements Serializable {
    private int booklistID;
    private String name;
    private String author;
    private int price;
    private String isbn;
    private int stock;
    private int sales;
    private List<Cart> carts=new ArrayList();
    private int status;
    private static final long serialVersionUID = 4L;
    @Id
    @Column(name = "booklistID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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


    @Basic
    @Column(name="sales")
    public int getSales() {return sales;}
    public void setSales(int sales) {this.sales = sales;}

    @Basic
    @Column(name="status")
    public int getStatus() {return status;}
    public void setStatus(int status) {this.status=status;}

    @OneToMany(targetEntity =Cart.class, mappedBy = "book",cascade = CascadeType.ALL)
    public List<Cart> getCarts()
    {
        return carts;
    }

    public void setCarts(List<Cart> carts)
    {
       this.carts=carts;
    }

    public Booklist()
    {

    }

    public Booklist(String name, String author,int price,String isbn, int stock)
    {
        this.name=name;
        this.author=author;
        this.price=price;
        this.isbn=isbn;
        this.stock=stock;
        this.sales=0;
        this.status=0;
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
        if (!Objects.equals(carts, that.carts)) return false;
        if (!Objects.equals(status, that.status)) return false;



        return true;
    }

    @Override
    public int hashCode() {
        int result = booklistID;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (carts != null ? carts.hashCode() : 0);
        result = 31 * result + stock;
        result = 31 * result + price;
        result = 31 * result + sales;
        result = 31 * result + status;
        return result;
    }





}


