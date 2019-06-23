package com.macoredroid.onlinebookstore.service;

public interface ChangeBookService {
    boolean changeName(String bookID,String newbookname);
    boolean changePrice(String bookID,String newbookprice);
    boolean changeAuthor(String bookID, String newauthorname);
    boolean changeStock(String bookID,String newstock);
    boolean changeIsbn(String bookID,String isbn);
}
