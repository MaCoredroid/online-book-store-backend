package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Order;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.service.DirectlyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectlyOrderServiceimpl implements DirectlyOrderService {
    @Autowired
    private BooklistDao booklistDao;
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Override
    public boolean DirectlyOrder(String username, String isbn, String number, String time) {
        Booklist tempBook=booklistDao.findByIsbn(isbn);
        User tempUser=userDao.findOne(username);
        if(tempBook==null)
        {
            return false;
        }
        if(tempBook.getStatus()==0)
        {
            return false;
        }
        if(tempUser==null)
        {
            return false;
        }
        int tempOrdernum = Integer.parseInt(number);
        int tempStocknum = tempBook.getStock();
        if (tempStocknum < tempOrdernum)
        {
            return false;
        }
        else
        {
            tempBook.setStock(tempStocknum-tempOrdernum);
            int sales=tempBook.getSales();
            sales+=tempOrdernum;
            tempBook.setSales(sales);
            booklistDao.save(tempBook);
            Order temporder=new Order(isbn,time,tempOrdernum,tempUser.getUserID(),tempBook.getName(),tempBook.getAuthor(),tempBook.getPrice(),username,tempBook.getBooklistID());
            orderDao.save(temporder);
            return true;
        }

    }
}
