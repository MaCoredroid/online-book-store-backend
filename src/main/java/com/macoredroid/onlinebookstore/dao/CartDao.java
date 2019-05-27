package com.macoredroid.onlinebookstore.dao;

import com.macoredroid.onlinebookstore.entity.Cart;

public interface CartDao {
    void save(Cart cart);
    Cart findOne(Integer id);
    void remove(Integer id);
}
