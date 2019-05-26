package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.dao.OrderDao;
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
    private OrderDao OrderDao;
    @Autowired
    private BooklistDao BooklistDao;
    @Override
    public List<Orderinfo> findAllByUsername(String username) {
        List<Orderinfo> resultlist= new ArrayList();
        List<Order> templist=OrderDao.findAllByUsername(username);
        for(Order temporder:templist) {
            temporder.setIsbn(temporder.getIsbn().replaceAll("[^\\x00-\\x7F]", ""));
            if(BooklistDao.findByIsbn(temporder.getIsbn())==null)
            {
                return null;
            }
            Booklist temp= BooklistDao.findByIsbn(temporder.getIsbn());
            resultlist.add(new Orderinfo(temp.getIsbn(), temporder.getNumber(),temp.getAuthor(),temp.getPrice(), temp.getName()));
        }

        return resultlist;
    }

    @Override
    public List<Order> findAllbyUsernameAndTime(String username, String before, String After) {
        return null;
    }
}
