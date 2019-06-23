package com.macoredroid.onlinebookstore.info;

public class bookinfo {
    public int booklistID;
    public String name;
    public String author;
    public int price;
    public String isbn;
    public int stock;
    public int sales;
    public bookinfo(int booklistID,String name,String author,int price,String isbn,int stock,int sales)
    {
        this.booklistID=booklistID;
        this.name=name;
        this.author=author;
        this.price=price;
        this.isbn=isbn;
        this.stock=stock;
        this.sales=sales;
    }

}
