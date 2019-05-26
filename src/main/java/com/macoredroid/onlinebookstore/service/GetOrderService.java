package com.macoredroid.onlinebookstore.service;

import com.macoredroid.onlinebookstore.entity.Order;

import java.util.List;

public interface GetOrderService {
    List<Order> findAllByUsername(String username);
    List<Order> findAllbyUsernameAndTime(String username, String before,String After);
}
