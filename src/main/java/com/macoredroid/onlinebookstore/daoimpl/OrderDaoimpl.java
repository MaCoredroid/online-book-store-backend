package com.macoredroid.onlinebookstore.daoimpl;

import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.macoredroid.onlinebookstore.repository.OrderRepository;

import java.util.List;
@Repository
public class OrderDaoimpl implements OrderDao {
    @Autowired
    private OrderRepository OrderRepository;


    @Override
    public List<Order> findAllByIsbn(String isbn) {
        return OrderRepository.findAllByIsbn(isbn);
    }

    @Override
    public void save(Order order) {
        OrderRepository.save(order);
    }

    @Override
    public Order findOne(Integer id)
    {
        return OrderRepository.findById(id).get();
    }

    @Override
    public List<Order> findAll() {
        return OrderRepository.findAll();
    }

    @Override
    public List<Order> findAllByUserid(int id) {
        return OrderRepository.findAllByUserid(id);
    }


}
