package com.macoredroid.onlinebookstore.daoimpl;

import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class OrderDaoimpl implements OrderDao {
    @Autowired
    private com.macoredroid.onlinebookstore.repository.OrderRepository OrderRepository;

    @Override
    public List<Order> findAllByUsername(String username) {
        username =username.replaceAll("[^\\x00-\\x7F]", "");
        return OrderRepository.findAIIByUsername(username);
    }

    @Override
    public List<Order> findAllByIsbn(String isbn) {
        return OrderRepository.findAllByIsbn(isbn);
    }
}
