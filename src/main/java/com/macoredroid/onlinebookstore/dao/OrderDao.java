package com.macoredroid.onlinebookstore.dao;

import com.macoredroid.onlinebookstore.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAllByIsbn(String isbn);
    void save(Order order);
    Order findOne(Integer id);
    List<Order> findAll();
    List<Order> findAllByUserid(int id);
}
