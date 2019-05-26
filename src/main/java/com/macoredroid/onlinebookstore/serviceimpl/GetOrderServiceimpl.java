package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.entity.Order;
import com.macoredroid.onlinebookstore.service.GetOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GetOrderServiceimpl implements GetOrderService {
    @Autowired
    private OrderDao OrderDao;
    @Override
    public List<Order> findAllByUsername(String username) {
        return OrderDao.findAllByUsername(username);
    }

    @Override
    public List<Order> findAllbyUsernameAndTime(String username, String before, String After) {
        return null;
    }
}
