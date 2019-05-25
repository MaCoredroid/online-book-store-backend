package com.macoredroid.onlinebookstore.service;

import com.macoredroid.onlinebookstore.entity.Booklist;

import java.util.List;

public interface BooklistService {
    Booklist findBookByID(Integer id);
    Booklist findByIsbn(String isbn);
    List<Booklist> findAll();
}
