package com.macoredroid.onlinebookstore.info;

public class bookinfo {
    public int booklistID;
    public String name;
    public String author;
    public Double price;
    public String isbn;
    public int stock;
    public bookinfo(int booklistID,String name,String author,Double price,String isbn,int stock)
    {
        this.booklistID=booklistID;
        this.name=name;
        this.author=author;
        this.price=price;
        this.isbn=isbn;
        this.stock=stock;
    }

}
