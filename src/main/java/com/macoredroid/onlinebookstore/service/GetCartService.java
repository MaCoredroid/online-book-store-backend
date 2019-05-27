package com.macoredroid.onlinebookstore.service;

import com.macoredroid.onlinebookstore.info.Cartinfo;

import java.util.List;

public interface GetCartService {
    List<Cartinfo> findAllByUsername(String username);
}
