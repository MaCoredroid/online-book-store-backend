package com.macoredroid.onlinebookstore.info;

public class Orderinfo {
    public String timestamp;
    public int OrderID;
    public String isbn;
    public int    number;
    public String name;
    public String author;
    public int price;
    public int userid;
    public String username;


     public Orderinfo(String timestamp,int OrderID,String isbn,int number,String name, String author,int price,String username,int userid)
    {
        this.timestamp=timestamp;
        this.OrderID=OrderID;
        this.isbn=isbn;
        this.number=number;
        this.author=author;
        this.name=name;
        this.price=price;
        this.username=username;
        this.userid=userid;
    }
}
