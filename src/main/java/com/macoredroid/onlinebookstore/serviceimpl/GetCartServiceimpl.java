package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.CartDao;
import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Cart;
import com.macoredroid.onlinebookstore.info.Cartinfo;
import com.macoredroid.onlinebookstore.service.GetCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GetCartServiceimpl implements GetCartService {

    @Autowired
    private UserDao UserDao;
    @Autowired
    private CartDao CartDao;
    @Override
    public List<Cartinfo> findAllByUsername(String username) {
        List<Cartinfo> resultlist= new ArrayList();
        List<Cart> templist= UserDao.findOne(username).getCarts();
        for(Cart tempcart:templist) {
            Booklist temp=tempcart.getBook();
            resultlist.add(new Cartinfo(tempcart.getTime(),Integer.toString(tempcart.getCartid()),temp.getIsbn(), tempcart.getNumber(),temp.getAuthor(),temp.getPrice(), temp.getName(),username,temp.getBooklistID()));
        }

        return resultlist;
    }

    @Override
    public List<Cartinfo> findAll() {
        List<Cartinfo> resultlist= new ArrayList();
        List<Cart> templist=CartDao.findAll();
        for(Cart tempcart:templist) {
            Booklist temp=tempcart.getBook();
            resultlist.add(new Cartinfo(tempcart.getTime(),Integer.toString(tempcart.getCartid()),temp.getIsbn(), tempcart.getNumber(),temp.getAuthor(),temp.getPrice(), temp.getName(),tempcart.getUser().getUsername(),temp.getBooklistID()));
        }
        return resultlist;

    }

    @Override
    public Cartinfo findOne(int id)
    {
        Cart tempcart=CartDao.findOne(id);
        if(tempcart==null)
        {
            return null;
        }
        else
        {
            Booklist temp=tempcart.getBook();
            Cartinfo res=new Cartinfo(tempcart.getTime(),Integer.toString(tempcart.getCartid()),temp.getIsbn(), tempcart.getNumber(),temp.getAuthor(),temp.getPrice(), temp.getName(),tempcart.getUser().getUsername(),temp.getBooklistID());
            return res;
        }
    }
}
