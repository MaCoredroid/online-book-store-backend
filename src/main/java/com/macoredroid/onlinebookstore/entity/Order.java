package com.macoredroid.onlinebookstore.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
@Entity
@Table(name = "orders", schema = "test", catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "orderid")
public class Order implements Serializable {
    private int orderid;
    private String isbn;
    private String time;
    private int number;
    private int userid;
    private int bookid;
    private String username;
    private String name;
    private String author;
    private int price;
    private static final long serialVersionUID = 4L;


    @Id
    @Column(name = "orderid")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    public int getOrderid() { return orderid; }
    public void setOrderid(int orderid) { this.orderid=orderid; }

    @Basic
    @Column(name= "bookid")
    public int getBookid() {return bookid;}
    public void setBookid(int id) {this.bookid=id;}



    @Basic
    @Column(name = "userid")
    public int getUserid() { return userid; }
    public void setUserid(int id) { this.userid=id; }

    @Basic
    @Column(name="name")
    public String getName(){return name;}
    public void setName(String name) {this.name = name;}

    @Basic
    @Column(name="author")
    public String getAuthor() {return author;}
    public void setAuthor(String author) {this.author = author;}

    @Basic
    @Column(name = "price")
    public int getPrice() {return price;}
    public void setPrice(int price) {this.price=price;}


    @Basic
    @Column(name = "time")
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
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
    @Column(name= "username")
    public String getUsername() {return username;}
    public void setUsername(String username) {this.username=username;}

    @Basic
    @Column(name = "number")
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number =number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order that = (Order) o;

        if (orderid != that.orderid) return false;
        if (!Objects.equals(userid, that.userid)) return false;
        if (!Objects.equals(number, that.number)) return false;
        if (!Objects.equals(isbn, that.isbn)) return false;
        if (!Objects.equals(time, that.time)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(author, that.author)) return false;
        if (!Objects.equals(price, that.price)) return false;
        if (!Objects.equals(username, that.username)) return false;
        if (!Objects.equals(bookid, that.bookid)) return false;


        return true;
    }

    @Override
    public int hashCode() {
        int result = orderid;
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + number;
        result = 31 * result + userid;
        result = 31 * result + price;
        result = 31 * result + bookid;
        return result;
    }

    private Order()
    {

    }

    public Order(String isbn, String time, int number, int id, String name, String author, int price,String username,int bookid)
    {
        this.isbn=isbn;
        this.time=time;
        this.number=number;
        this.userid=id;
        this.name=name;
        this.author=author;
        this.price=price;
        this.username=username;
        this.bookid=bookid;
    }


}
