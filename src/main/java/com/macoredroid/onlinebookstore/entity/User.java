package com.macoredroid.onlinebookstore.entity;

import com.fasterxml.jackson.annotation.*;


import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;
@Entity
@Table(name = "users", schema = "test", catalog = "")
@JsonIgnoreProperties(value = {"handler","hibernateLazyInitializer","fieldHandler"})
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "userID")
public class User {
    private int userID;
    private String username;
    private String password;
    private String email;
    private int star;

    @Id
    @Column(name = "userID")
    @GeneratedValue(strategy = IDENTITY)
    public int getUserID() { return userID; }

    public void setUserID(int userID) { this.userID=userID; }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "star")
    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star =star;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User that = (User) o;

        if (userID != that.userID) return false;
        if (!Objects.equals(username, that.username)) return false;
        if (!Objects.equals(password, that.password)) return false;
        if (!Objects.equals(email, that.email)) return false;
        if (!Objects.equals(star, that.star)) return false;



        return true;
    }

    @Override
    public int hashCode() {
        int result = userID;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + star;
        return result;
    }


}
