package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.Order;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.info.Orderinfo;
import com.macoredroid.onlinebookstore.service.GetOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class GetOrderServiceimpl implements GetOrderService {
    @Autowired
    private BooklistDao BooklistDao;
    @Autowired
    private UserDao UserDao;
    @Autowired
    private OrderDao OrderDao;
    @Override
    public List<Orderinfo> findAllByUsername(String username) {
        List<Orderinfo> resultlist= new ArrayList();
        User tempUser=UserDao.findOne(username);
        if(tempUser==null)
        {
            return null;
        }
        List<Order> templist= OrderDao.findAllByUserid(tempUser.getUserID());
        for(Order temporder:templist) {
            resultlist.add(new Orderinfo(temporder.getTime(),temporder.getOrderid(),temporder.getIsbn(),temporder.getNumber(),temporder.getAuthor(),temporder.getName(),temporder.getPrice(),username,temporder.getUserid()));
        }

        return resultlist;
    }

    @Override
    public List<Orderinfo> findAll() {
        List<Orderinfo> resultlist= new ArrayList();
        List<Order> templist= OrderDao.findAll();
        for(Order temporder:templist) {
            resultlist.add(new Orderinfo(temporder.getTime(),temporder.getOrderid(),temporder.getIsbn(),temporder.getNumber(),temporder.getAuthor(),temporder.getName(),temporder.getPrice(),temporder.getUsername(),temporder.getUserid()));
        }
        return resultlist;
    }
}
