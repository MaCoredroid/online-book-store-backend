package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Cover;
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
    public bookinfo findBookByID(Integer id)
    {
        Booklist tempbook = BooklistDao.findOne(id);
        if(tempbook==null)
        {
            return null;
        }
        else
        {
            bookinfo tempbookinfo=new bookinfo(tempbook.getBooklistID(),tempbook.getName(),tempbook.getAuthor(),tempbook.getPrice(),tempbook.getIsbn(),tempbook.getStock(),tempbook.getSales());
            return tempbookinfo;
        }
    }


    @Override
    public List<bookinfo> findAll()
    {

        List<Booklist> templist=BooklistDao.findAll();
        List<bookinfo> resultlist=new ArrayList<>();
        for(Booklist tempbook:templist)
        {
            List<Order> tempOrderlist = OrderDao.findAllByIsbn(tempbook.getIsbn());
            bookinfo tempbookinfo=new bookinfo(tempbook.getBooklistID(),tempbook.getName(),tempbook.getAuthor(),tempbook.getPrice(),tempbook.getIsbn(),tempbook.getStock(),tempbook.getSales());
            resultlist.add(tempbookinfo);
        }
        return resultlist;
    }

    @Override
    public byte[] findCoverByID(String id) {
        Booklist tempbook = BooklistDao.findOne(Integer.parseInt(id));
        if(tempbook==null)
        {
            return null;
        }
        else
        {
            return BooklistDao.findCoverBybookid(id);
        }
    }

    @Override
    public boolean setCover(String id, byte[] cover)
    {
        Booklist tempbook = BooklistDao.findOne(Integer.parseInt(id));
        if(tempbook==null)
        {
            return false;
        }
        else
        {
            Cover temp=new Cover(id,cover);
            BooklistDao.saveCover(temp);
            return true;
        }
    }
}
