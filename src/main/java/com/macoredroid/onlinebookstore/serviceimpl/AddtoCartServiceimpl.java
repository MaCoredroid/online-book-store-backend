package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.dao.CartDao;
import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Cart;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.service.AddtoCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AddtoCartServiceimpl implements AddtoCartService {
    @Autowired
    private BooklistDao booklistDao;
    @Autowired
    private CartDao cartDao;
    @Autowired
    private UserDao userDao;
    @Override
    public Boolean AddtoCart(String time, int number, String isbn, String username) {
        Booklist tempBook=booklistDao.findByIsbn(isbn);
        User tempUser=userDao.findOne(username);
        if(tempUser==null)
        {
            return false;
        }
        if(tempBook==null)
        {
            return false;
        }
        Cart tempcart=new Cart(time,number,tempBook,tempUser);

        List<Cart> cartlist=tempBook.getCarts();
        cartlist.add(tempcart);
        tempBook.setCarts(cartlist);

        List<Cart> cartlistan=tempUser.getCarts();
        cartlistan.add(tempcart);
        tempUser.setCarts(cartlistan);

        cartDao.save(tempcart);
        userDao.save(tempUser);
        booklistDao.save(tempBook);
        return true;
    }
}
