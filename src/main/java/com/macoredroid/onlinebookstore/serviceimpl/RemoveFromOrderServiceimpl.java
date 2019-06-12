package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.Order;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.service.RemoveFromOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemoveFromOrderServiceimpl implements RemoveFromOrderService {
    @Autowired
    private OrderDao OrderDao;
    @Autowired
    private UserDao userDao;
    @Override
    public boolean RemoveFromOrder(Integer id) {
        Order tempOrder=OrderDao.findOne(id);
        if(tempOrder==null)
        {
            return false;
        }
        User tempUser=tempOrder.getOwner();
        if(tempUser==null)
        {
            return false;
        }
        List<Order> tempUserOrders= tempUser.getOrders();
        tempUserOrders.remove(tempOrder);
        tempUser.setOrders(tempUserOrders);
        userDao.save(tempUser);
        OrderDao.remove(id);
        return true;
    }
}
