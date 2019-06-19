package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Order;
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
        List<Order> templist= UserDao.findOne(username).getOrders();
        for(Order temporder:templist) {
            temporder.setIsbn(temporder.getIsbn().replaceAll("[^\\x00-\\x7F]", ""));
            if(BooklistDao.findByIsbn(temporder.getIsbn())==null)
            {
                return null;
            }
            Booklist temp= BooklistDao.findByIsbn(temporder.getIsbn());
            resultlist.add(new Orderinfo(temporder.getTime(),Integer.toString(temporder.getOrderid()),temp.getIsbn(), temporder.getNumber(),temp.getAuthor(),temp.getPrice(), temp.getName(),username));
        }

        return resultlist;
    }

    @Override
    public List<Orderinfo> findAll() {
        List<Orderinfo> resultlist= new ArrayList();
        List<Order> templist= OrderDao.findAll();
        for(Order temporder:templist) {
            temporder.setIsbn(temporder.getIsbn().replaceAll("[^\\x00-\\x7F]", ""));
            if(BooklistDao.findByIsbn(temporder.getIsbn())==null)
            {
                return null;
            }
            Booklist temp= BooklistDao.findByIsbn(temporder.getIsbn());
            resultlist.add(new Orderinfo(temporder.getTime(),Integer.toString(temporder.getOrderid()),temp.getIsbn(), temporder.getNumber(),temp.getAuthor(),temp.getPrice(), temp.getName(),temporder.getOwner().getUsername()));
        }
        return resultlist;
    }
}
