package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.service.ChangeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeBookServiceimpl implements ChangeBookService {
    @Autowired
    private BooklistDao BooklistDao;
    @Override
    public boolean changeName(String bookID, String newbookname) {
        Booklist tempBook= BooklistDao.findByName(newbookname);
        if(tempBook!=null)
        {
            return false;
        }
        else
        {
            Booklist oldBook= BooklistDao.findOne(Integer.parseInt(bookID));
            if(oldBook==null)
            {
                return false;
            }
            else
            {
                oldBook.setName(newbookname);
                BooklistDao.save(oldBook);
                return true;
            }
        }

    }

    @Override
    public boolean changePrice(String bookID, String newbookprice) {
        Booklist oldBook= BooklistDao.findOne(Integer.parseInt(bookID));
        if(oldBook==null)
        {
            return false;
        }
        else
        {
            oldBook.setPrice(Integer.parseInt(newbookprice));
            BooklistDao.save(oldBook);
            return true;
        }
    }

    @Override
    public boolean changeAuthor(String bookID, String newauthorname) {
        Booklist oldBook= BooklistDao.findOne(Integer.parseInt(bookID));
        if(oldBook==null)
        {
            return false;
        }
        else
        {
            oldBook.setAuthor(newauthorname);
            BooklistDao.save(oldBook);
            return true;
        }
    }

    @Override
    public boolean changeStock(String bookID, String newstock)
    {
        Booklist oldBook= BooklistDao.findOne(Integer.parseInt(bookID));
        if(oldBook==null)
        {
            return false;
        }
        else
        {
            if (Integer.parseInt(newstock) >= 0)
            {
                oldBook.setStock(Integer.parseInt(newstock));
                BooklistDao.save(oldBook);
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    @Override
    public boolean changeIsbn(String bookID, String isbn) {
        Booklist oldBook= BooklistDao.findOne(Integer.parseInt(bookID));
        if(oldBook==null)
        {
            return false;
        }
        else
        {
            Booklist temp=BooklistDao.findByIsbn(isbn);
            if(temp!=null)
            {
                return false;
            }
            else
            {
                oldBook.setIsbn(isbn);
                BooklistDao.save(oldBook);
                return true;
            }
        }
    }
}
