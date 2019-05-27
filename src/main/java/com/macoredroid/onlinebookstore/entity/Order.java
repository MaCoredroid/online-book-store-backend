package com.macoredroid.onlinebookstore.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    private User owner;
    private static final long serialVersionUID = 4L;


    @Id
    @Column(name = "orderid")
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    public int getOrderid() { return orderid; }

    public void setOrderid(int orderid) { this.orderid=orderid; }



    @Basic
    @ManyToOne(fetch=FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "username",referencedColumnName="username")
    public User getOwner() {

        return owner;
    }

    public void setOwner(User owner) {

        this.owner = owner;
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
        if (!Objects.equals(owner, that.owner)) return false;
        if (!Objects.equals(number, that.number)) return false;
        if (!Objects.equals(isbn, that.isbn)) return false;
        if (!Objects.equals(time, that.time)) return false;



        return true;
    }

    @Override
    public int hashCode() {
        int result = orderid;
        result = 31 * result + (owner != null ? owner.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + number;
        return result;
    }


}