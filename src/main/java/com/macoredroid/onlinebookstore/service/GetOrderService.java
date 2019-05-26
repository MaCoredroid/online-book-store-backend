package com.macoredroid.onlinebookstore.service;

import com.macoredroid.onlinebookstore.entity.Order;
import com.macoredroid.onlinebookstore.info.Orderinfo;

import java.util.List;

public interface GetOrderService {
    List<Orderinfo> findAllByUsername(String username);
    List<Order> findAllbyUsernameAndTime(String username, String before,String After);
}
