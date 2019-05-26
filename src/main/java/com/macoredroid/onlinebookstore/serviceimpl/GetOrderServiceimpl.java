package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Order;
import com.macoredroid.onlinebookstore.info.Orderinfo;
import com.macoredroid.onlinebookstore.service.GetOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GetOrderServiceimpl implements GetOrderService {
    List<Orderinfo> resultlist;
    @Autowired
    private OrderDao OrderDao;
    private BooklistDao BooklistDao;
    @Override
    public List<Orderinfo> findAllByUsername(String username) {
        List<Order> templist=OrderDao.findAllByUsername(username);
        for(Order temporder:templist)
        {
            String tempisbn=temporder.getIsbn().replaceAll("[^\\x00-\\x7F]", "");
            System.out.println(tempisbn);
            Booklist tempBooklist=BooklistDao.findByIsbn("978-3-16-148410-0");
            resultlist.add(new Orderinfo(BooklistDao.findByIsbn(tempisbn).getIsbn(),temporder.getNumber(),tempBooklist.getAuthor(),tempBooklist.getPrice(),tempBooklist.getName()));
        }
        return resultlist;
    }

    @Override
    public List<Order> findAllbyUsernameAndTime(String username, String before, String After) {
        return null;
    }
}
