package com.macoredroid.onlinebookstore.dao;

import com.macoredroid.onlinebookstore.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAllByIsbn(String isbn);
    void save(Order order);
    void remove(Integer id);
    Order findOne(Integer id);
}
