package com.macoredroid.onlinebookstore.dao;

import com.macoredroid.onlinebookstore.entity.Booklist;

import java.util.List;

public interface BooklistDao {
    Booklist findOne(Integer id);
    Booklist findByIsbn(String isbn);
    Booklist findByName(String name);
    List<Booklist> findAll();
    void save(Booklist booklist);
}
