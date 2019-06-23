package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.dao.CartDao;
import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Cart;
import com.macoredroid.onlinebookstore.entity.Order;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PurchaseServiceimpl implements PurchaseService {
    @Autowired
    private BooklistDao booklistDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private OrderDao orderDao;
    @Override
    public boolean Purchase(int CartID,String time) {
        Cart tempcart= cartDao.findOne(CartID);
        if(tempcart==null)
        {
            return false;
        }
        else
        {
            Booklist tempbook = tempcart.getBook();
            User tempuser = tempcart.getUser();
            int tempOrdernum = tempcart.getNumber();
            int tempStocknum = tempbook.getStock();
            if (tempStocknum < tempOrdernum)
            {
                return false;
            }
            else
            {
                Order temporder=new Order(tempbook.getIsbn(),time,tempcart.getNumber(), tempuser.getUserID(),tempbook.getName(),tempbook.getAuthor(),tempbook.getPrice(),tempuser.getUsername(),tempbook.getBooklistID());
                orderDao.save(temporder);
                List<Cart> tempCartlist=tempuser.getCarts();
                tempCartlist.remove(tempcart);
                tempuser.setCarts(tempCartlist);
                userDao.save(tempuser);
                List<Cart> tempCartlistan=tempbook.getCarts();
                tempCartlistan.remove(tempcart);
                tempbook.setCarts(tempCartlistan);
                tempbook.setStock(tempStocknum-tempOrdernum);
                int sales=tempbook.getSales();
                tempbook.setSales(sales+tempOrdernum);
                booklistDao.save(tempbook);
                cartDao.remove(CartID);
                return true;
            }
        }
    }
}
