package com.macoredroid.onlinebookstore.service;

import com.macoredroid.onlinebookstore.entity.Order;

import java.util.List;

public interface GetSalesService {
    List<Order> GetOrderByIsbn(String isbn);
    List<Order> GetOrderByTime(String before, String after);
}
