package com.macoredroid.onlinebookstore.info;

public class Orderinfo {
    public String isbn;
    public int    number;
    public String name;
    public String author;
    public Double price;



     public Orderinfo(String isbn,int number,String author,Double price,String name)
    {
        this.isbn=isbn;
        this.number=number;
        this.author=author;
        this.name=name;
        this.price=price;
    }
}
