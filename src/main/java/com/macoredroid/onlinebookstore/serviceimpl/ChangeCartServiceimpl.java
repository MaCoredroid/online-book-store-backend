package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.CartDao;
import com.macoredroid.onlinebookstore.entity.Cart;
import com.macoredroid.onlinebookstore.service.ChangeCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeCartServiceimpl implements ChangeCartService {
    @Autowired
    private CartDao cartDao;
    @Override
    public boolean ChangeCart(int CartID, int number) {
        Cart tempcart= cartDao.findOne(CartID);
        if(tempcart==null)
        {
            return false;
        }
        else
        {
            tempcart.setNumber(number);
            cartDao.save(tempcart);
            return true;
        }
    }
}
