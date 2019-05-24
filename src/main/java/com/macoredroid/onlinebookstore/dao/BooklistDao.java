package com.macoredroid.onlinebookstore.dao;

import com.macoredroid.onlinebookstore.entity.Booklist;

public interface BooklistDao {
    Booklist findOne(Integer id);
}
