package com.macoredroid.onlinebookstore.daoimpl;

import com.macoredroid.onlinebookstore.dao.CartDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Cart;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CartDaoimpl implements CartDao {
    @Autowired
    private CartRepository CartRepository;


    @Override
    public void save(Cart cart) {
        CartRepository.save(cart);
    }


}
