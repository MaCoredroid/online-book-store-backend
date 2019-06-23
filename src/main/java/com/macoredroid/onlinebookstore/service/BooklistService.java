package com.macoredroid.onlinebookstore.service;

import com.macoredroid.onlinebookstore.info.bookinfo;

import java.util.List;

public interface BooklistService {
    bookinfo findBookByID(Integer id);
    List<bookinfo> findAll();
}
