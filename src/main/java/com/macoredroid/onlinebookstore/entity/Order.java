package com.macoredroid.onlinebookstore.entity;

import com.fasterxml.jackson.annotation.*;


import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "orders", schema = "test", catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "orderid")
public class Order {
    private int orderid;
    private String isbn;
    private String username;
    private String time;
    private int number;

    @Id
    @Column(name = "orderid")
    @GeneratedValue(strategy = IDENTITY)
    public int getOrderid() { return orderid; }

    public void setOrderid(int orderid) { this.orderid=orderid; }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username= username;
    }

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
        if (!Objects.equals(username, that.username)) return false;
        if (!Objects.equals(number, that.number)) return false;
        if (!Objects.equals(isbn, that.isbn)) return false;
        if (!Objects.equals(time, that.time)) return false;



        return true;
    }

    @Override
    public int hashCode() {
        int result = orderid;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + number;
        return result;
    }


}