package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.dao.CartDao;
import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Cart;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.service.RemoveFromCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RemoveFromCartServiceimpl implements RemoveFromCartService {
    @Autowired
    private BooklistDao booklistDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private UserDao userDao;
    @Override
    public boolean RemoveFromCart(int CartID) {
        Cart tempcart= cartDao.findOne(CartID);
        Booklist tempbook =cartDao.findOne(CartID).getBook();
        User tempuser=cartDao.findOne(CartID).getUser();
        if(tempuser==null||tempbook==null)
        {
            return false;
        }



        List<Cart> tempcartlistan=tempuser.getCarts();
        tempcartlistan.remove(tempcart);
        tempuser.setCarts(tempcartlistan);

        booklistDao.save(tempbook);
        userDao.save(tempuser);
        cartDao.remove(CartID);


        return true;
    }
}
