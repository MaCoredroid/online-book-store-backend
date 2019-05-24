package com.macoredroid.onlinebookstore.service;

import com.macoredroid.onlinebookstore.entity.Booklist;

public interface BooklistService {
    Booklist findBookByID(Integer id);
}
