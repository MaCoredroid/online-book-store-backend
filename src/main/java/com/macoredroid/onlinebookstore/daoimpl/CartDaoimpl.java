package com.macoredroid.onlinebookstore.daoimpl;

import com.macoredroid.onlinebookstore.dao.CartDao;
import com.macoredroid.onlinebookstore.entity.Cart;
import com.macoredroid.onlinebookstore.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDaoimpl implements CartDao {
    @Autowired
    private CartRepository CartRepository;


    @Override
    public void save(Cart cart) {
        CartRepository.saveAndFlush(cart);
    }

    @Override
    public Cart findOne(Integer id) {
        return CartRepository.findById(id).get();
    }

    @Override
    public void remove(Integer id) {
        CartRepository.deleteById(id);
    }

    @Override
    public List<Cart> findAll() {
        return CartRepository.findAll();
    }


}
