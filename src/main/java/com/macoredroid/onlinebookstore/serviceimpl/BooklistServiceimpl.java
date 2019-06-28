package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Cover;
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
    public bookinfo findBookByID(Integer id) {
        Booklist tempbook = BooklistDao.findOne(id);
        if (tempbook == null) {
            return null;
        } else {
            bookinfo tempbookinfo = new bookinfo(tempbook.getBooklistID(), tempbook.getName(), tempbook.getAuthor(), tempbook.getPrice(), tempbook.getIsbn(), tempbook.getStock(), tempbook.getSales(),true);
            return tempbookinfo;
        }
    }


    @Override
    public List<bookinfo> findAll() {

        List<Booklist> templist = BooklistDao.findAll();
        List<bookinfo> resultlist = new ArrayList<>();
        for (Booklist tempbook : templist) {
            bookinfo tempbookinfo=new bookinfo();
            if(tempbook.getStatus()==1)
            {
                tempbookinfo = new bookinfo(tempbook.getBooklistID(), tempbook.getName(), tempbook.getAuthor(), tempbook.getPrice(), tempbook.getIsbn(), tempbook.getStock(), tempbook.getSales(),true);
            }
            else
            {
                tempbookinfo = new bookinfo(tempbook.getBooklistID(), tempbook.getName(), tempbook.getAuthor(), tempbook.getPrice(), tempbook.getIsbn(), tempbook.getStock(), tempbook.getSales(),false);
            }
            resultlist.add(tempbookinfo);
        }
        return resultlist;
    }

    @Override
    public List<bookinfo> UserfindAll() {
        List<Booklist> templist = BooklistDao.findAll();
        List<bookinfo> resultlist = new ArrayList<>();
        for (Booklist tempbook : templist) {
           if(tempbook.getStatus()==1)
           {
               bookinfo tempbookinfo = new bookinfo(tempbook.getBooklistID(), tempbook.getName(), tempbook.getAuthor(), tempbook.getPrice(), tempbook.getIsbn(), tempbook.getStock(), tempbook.getSales(),true);
               resultlist.add(tempbookinfo);
           }
        }
        return resultlist;
    }

    @Override
    public byte[] findCoverByID(String id) {
        Booklist tempbook = BooklistDao.findOne(Integer.parseInt(id));
        if (tempbook == null) {
            return null;
        } else {
            return BooklistDao.findCoverBybookid(id);
        }
    }

    @Override
    public boolean setCover(String id, byte[] cover) {
        Booklist tempbook = BooklistDao.findOne(Integer.parseInt(id));
        if (tempbook == null) {
            return false;
        } else {
            Cover temp = new Cover(id, cover);
            BooklistDao.saveCover(temp);
            return true;
        }
    }

    @Override
    public boolean block(String id) {
        Booklist tempbook = BooklistDao.findOne(Integer.parseInt(id));
        if (tempbook == null) {
            return false;
        }
        else
        {
            if(tempbook.getStatus()==0)
            {
                return false;
            }
            tempbook.setStatus(0);
            BooklistDao.save(tempbook);
            return true;
        }
    }

    @Override
    public boolean unblock(String id) {
        Booklist tempbook = BooklistDao.findOne(Integer.parseInt(id));
        if (tempbook == null) {
            return false;
        }
        else
        {
            if(tempbook.getStatus()==1)
            {
                return false;
            }
            tempbook.setStatus(1);
            BooklistDao.save(tempbook);
            return true;
        }
    }

    @Override
    public List<String> findAllbookid() {
        List<Booklist> temp = BooklistDao.findAll();
        List<String> bookidlist=new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            bookidlist.add(Integer.toString(temp.get(i).getBooklistID()));
        }
        return bookidlist;
    }

    @Override
    public List<String> userfindAllbookid() {
        List<Booklist> temp = BooklistDao.findAll();
        List<String> bookidlist=new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i).getStatus()==1)
            {
                bookidlist.add(Integer.toString(temp.get(i).getBooklistID()));
            }
        }
        return bookidlist;
    }
}

