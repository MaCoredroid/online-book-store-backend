package com.macoredroid.onlinebookstore.service;

import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.info.bookinfo;

import java.util.List;

public interface BooklistService {
    Booklist findBookByID(Integer id);
    bookinfo findByIsbn(String isbn);
    List<bookinfo> findAll();
}
