package com.macoredroid.onlinebookstore.service;

public interface ChangeBookService {
    boolean changeName(String bookID,String newbookname);
    boolean changePrice(String bookID,String newbookprice);
}
