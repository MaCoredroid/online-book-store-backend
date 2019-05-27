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
@Table(name = "carts", schema = "test", catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "cartid")
public class Cart implements Serializable {
    private int cartid;
    private String time;
    private int number;
    private Booklist book;
    private User user;
    private static final long serialVersionUID = 4L;

    @Id
    @Column(name = "cartid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getCartid() { return cartid; }

    public void setCartid(int cartid) { this.cartid=cartid; }

    @Basic
    @ManyToOne(fetch=FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "username",referencedColumnName = "username")
    public User getUser()
    {
        return user;
    }

    public void setUser(User user)
    {
        this.user=user;
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
    @OnDelete(action = OnDeleteAction.CASCADE)
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

    private Cart()
    {

    }

    public Cart(String time,int number,Booklist book,User user)
    {
        this.time=time;
        this.number=number;
        this.book=book;
        this.user=user;
    }





}