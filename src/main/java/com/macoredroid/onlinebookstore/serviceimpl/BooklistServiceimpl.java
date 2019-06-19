package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Order;
import com.macoredroid.onlinebookstore.info.bookinfo;
import com.macoredroid.onlinebookstore.service.BooklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BooklistServiceimpl implements BooklistService {
    @Autowired
    private BooklistDao BooklistDao;
    @Autowired
    private OrderDao OrderDao;
    @Override
    public Booklist findBookByID(Integer id) {
        return BooklistDao.findOne(id);
    }

    @Override
    public bookinfo findByIsbn(String isbn) {
        Booklist tempbook=BooklistDao.findByIsbn(isbn);
        List<Order> tempOrderlist = OrderDao.findAllByIsbn(isbn);
        int sales=0;
        for(Order tempOrder:tempOrderlist)
        {
            sales+=tempOrder.getNumber();
        }
        bookinfo result=new bookinfo(tempbook.getBooklistID(),tempbook.getName(),tempbook.getAuthor(),tempbook.getPrice(),tempbook.getIsbn(),tempbook.getStock(),sales);
        return result;
    }

    @Override
    public List<bookinfo> findAll()
    {

        List<Booklist> templist=BooklistDao.findAll();
        List<bookinfo> resultlist=new ArrayList<>();
        for(Booklist tempbook:templist)
        {
            List<Order> tempOrderlist = OrderDao.findAllByIsbn(tempbook.getIsbn());
            int sales=0;
            for(Order tempOrder:tempOrderlist)
            {
                sales+=tempOrder.getNumber();
            }
            bookinfo tempbookinfo=new bookinfo(tempbook.getBooklistID(),tempbook.getName(),tempbook.getAuthor(),tempbook.getPrice(),tempbook.getIsbn(),tempbook.getStock(),sales);
            resultlist.add(tempbookinfo);
        }
        return resultlist;
    }
}
