package com.macoredroid.onlinebookstore.info;

public class Cartinfo {
    public String CartID;
    public String timestamp;
    public String isbn;
    public int    number;
    public String name;
    public String author;
    public Double price;



    public Cartinfo(String timestamp,String CartID,String isbn,int number,String author,Double price,String name)
    {
        this.timestamp=timestamp;
        this.CartID=CartID;
        this.isbn=isbn;
        this.number=number;
        this.author=author;
        this.name=name;
        this.price=price;
    }
}