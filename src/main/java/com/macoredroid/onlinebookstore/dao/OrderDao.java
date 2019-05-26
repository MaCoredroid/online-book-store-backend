package com.macoredroid.onlinebookstore.dao;

import com.macoredroid.onlinebookstore.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> findAllByUsername(String username);
    List<Order> findAllByIsbn(String isbn);
}
