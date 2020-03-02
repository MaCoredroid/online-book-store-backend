package com.macoredroid.onlinebookstore.service;

import com.macoredroid.onlinebookstore.info.Orderinfo;

import java.util.List;

public interface GetOrderService {
    List<Orderinfo> findAllByUsername(String username);
    List<Orderinfo> findAll();
    Orderinfo findOne(int id);
}
