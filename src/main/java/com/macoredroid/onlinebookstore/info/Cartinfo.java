package com.macoredroid.onlinebookstore.info;

public class Cartinfo {
    public String CartID;
    public String timestamp;
    public String isbn;
    public int    number;
    public String name;
    public String author;
    public int price;
    public int bookid;
    public String username;
    public boolean status;



    public Cartinfo(String timestamp,String CartID,String isbn,int number,String author,int price,String name,String username,int bookid, boolean status)
    {
        this.timestamp=timestamp;
        this.CartID=CartID;
        this.isbn=isbn;
        this.number=number;
        this.author=author;
        this.name=name;
        this.price=price;
        this.username=username;
        this.bookid=bookid;
        this.status=status;
    }
}
