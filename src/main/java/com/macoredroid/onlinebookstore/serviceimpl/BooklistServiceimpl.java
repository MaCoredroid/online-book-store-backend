package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.service.BooklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BooklistServiceimpl implements BooklistService {
    @Autowired
    private BooklistDao BooklistDao;
    @Override
    public Booklist findBookByID(Integer id) {
        return BooklistDao.findOne(id);
    }
    @Override
    public List<Booklist> findAll()
    {
        return BooklistDao.findAll();
    }
}
