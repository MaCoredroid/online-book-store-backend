package com.macoredroid.onlinebookstore.info;

public class Orderinfo {
    public String timestamp;
    public String OrderID;
    public String isbn;
    public int    number;
    public String name;
    public String author;
    public Double price;
    public String username;


     public Orderinfo(String timestamp,String OrderID,String isbn,int number,String author,Double price,String name,String username)
    {
        this.timestamp=timestamp;
        this.OrderID=OrderID;
        this.isbn=isbn;
        this.number=number;
        this.author=author;
        this.name=name;
        this.price=price;
        this.username=username;
    }
}
