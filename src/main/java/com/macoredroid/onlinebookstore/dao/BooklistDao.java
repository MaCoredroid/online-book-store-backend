package com.macoredroid.onlinebookstore.dao;

import com.macoredroid.onlinebookstore.entity.Booklist;

import java.util.List;

public interface BooklistDao {
    Booklist findOne(Integer id);
    Booklist findByIsbn(String isbn);
    List<Booklist> findAll();
}
