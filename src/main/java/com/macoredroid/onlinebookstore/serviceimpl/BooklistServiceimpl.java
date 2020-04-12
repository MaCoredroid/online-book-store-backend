package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.dao.OrderDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Cover;
import com.macoredroid.onlinebookstore.info.bookinfo;
import com.macoredroid.onlinebookstore.service.BooklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BooklistServiceimpl extends UnicastRemoteObject implements BooklistService {
    @Autowired
    private BooklistDao BooklistDao;
    @Autowired
    private OrderDao OrderDao;

    @Autowired
    WebApplicationContext applicationContext;

    private Map<String, String> res;

    public BooklistServiceimpl() throws RemoteException {
        res=new HashMap<String, String>();
        res.put("How to Catch a Leprechaun","You've been planning night and day, and finally you've created the perfect trap! Now all you need to do is wait. Is this the year you'll finally catch the leprechaun? Start a St. Patrick's Day tradition with this fun and lively children's book.");
        res.put("American Dirt","This book is not simply the great American novel; it’s the great novel of las Americas. It’s the great world novel! This is the international story of our times. Masterful.");
    }

    @Override
    public bookinfo findBookByID(Integer id) throws RemoteException{
        Booklist tempbook = BooklistDao.findOne(id);
        if (tempbook == null) {
            return null;
        } else {
            bookinfo tempbookinfo = new bookinfo(tempbook.getBooklistID(), tempbook.getName(), tempbook.getAuthor(), tempbook.getPrice(), tempbook.getIsbn(), tempbook.getStock(), tempbook.getSales(),true);
            return tempbookinfo;
        }
    }

    @Override
    public String rmiFindBookDescription(String name) throws RemoteException {
        String ret= res.get(name);
        return ret==null?"":ret;
    }


    @Override
    public List<bookinfo> findAll() throws RemoteException{

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
    public List<bookinfo> UserfindAll() throws RemoteException{
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
    public byte[] findCoverByID(String id) throws RemoteException{
        Booklist tempbook = BooklistDao.findOne(Integer.parseInt(id));
        if (tempbook == null) {
            return null;
        } else {
            return BooklistDao.findCoverBybookid(id);
        }
    }

    @Override
    public String getDescriptionByBookId(String BookId) throws RemoteException{
        return BooklistDao.getDescriptionByBookId(BookId);
    }

    @Override
    public String searchInDescription(String word) throws Exception {
        return BooklistDao.searchInDescription(word);
    }

    @Override
    public boolean setCover(String id, byte[] cover) throws RemoteException{
        Booklist tempbook = BooklistDao.findOne(Integer.parseInt(id));
        if (tempbook == null)
        {
            return false;
        }
        else
        {
            Cover temp = new Cover(id, cover);
            BooklistDao.saveCover(temp);
            return true;
        }
    }

    @Override
    public boolean block(String id) throws RemoteException {
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
    public boolean unblock(String id) throws RemoteException {
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
    public List<String> findAllbookid() throws RemoteException{
        List<Booklist> temp = BooklistDao.findAll();
        List<String> bookidlist=new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            bookidlist.add(Integer.toString(temp.get(i).getBooklistID()));
        }
        return bookidlist;
    }

    @Override
    public List<String> userfindAllbookid() throws RemoteException{
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

    @Override
    public String NewBook(String name, String author, int price, String isbn, int stock) throws RemoteException{
        Booklist temp= BooklistDao.findByIsbn(isbn);
        if(temp!=null)
        {
            return "false";
        }
        Booklist temp1=BooklistDao.findByName(name);
        if(temp1!=null)
        {
            return "false";
        }
        Booklist newbook=new Booklist(name,author,price,isbn,stock);
        BooklistDao.save(newbook);
        return Integer.toString(newbook.getBooklistID());
    }

    @Override
    public boolean DeleteBook(String id) throws RemoteException {
        Booklist tempbook = BooklistDao.findOne(Integer.parseInt(id));
        if (tempbook == null) {
            return false;
        }
        else
        {
            BooklistDao.deleteOne(Integer.parseInt(id));
            BooklistDao.deleteCover(id);
            return true;
        }
    }
}

