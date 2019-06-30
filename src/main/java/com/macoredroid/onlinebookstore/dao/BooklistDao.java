package com.macoredroid.onlinebookstore.dao;

import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Cover;

import java.util.List;

public interface BooklistDao {
    Booklist findOne(Integer id);
    Booklist findByIsbn(String isbn);
    Booklist findByName(String name);
    List<Booklist> findAll();
    byte[] findCoverBybookid(String bookid);
    void save(Booklist booklist);
    void saveCover(Cover cover);
    void deleteOne(Integer id);
    void deleteCover(String id);
}
