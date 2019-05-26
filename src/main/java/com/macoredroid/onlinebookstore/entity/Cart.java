package com.macoredroid.onlinebookstore.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "carts", schema = "test", catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "cartid")
public class Cart {
    private int cartid;
    private String time;
    private int number;
    private Booklist book;
    private User user;

    @Id
    @Column(name = "cartid")
    @GeneratedValue(strategy = IDENTITY)
    public int getCartid() { return cartid; }

    public void setCartid(int cartid) { this.cartid=cartid; }

    @Basic
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "username",referencedColumnName = "username")
    public User getUser()
    {
        return user;
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "isbn",referencedColumnName = "isbn")
    public Booklist getBook()
    {
        return book;
    }

    public void setBook(Booklist book)
    {
        this.book=book;
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

        Cart that = (Cart) o;

        if (cartid != that.cartid) return false;
        if (!Objects.equals(user, that.user)) return false;
        if (!Objects.equals(number, that.number)) return false;
        if (!Objects.equals(book, that.book)) return false;
        if (!Objects.equals(time, that.time)) return false;



        return true;
    }

    @Override
    public int hashCode() {
        int result = cartid;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (book != null ? book.hashCode() : 0);
        result = 31 * result + number;
        return result;
    }


}