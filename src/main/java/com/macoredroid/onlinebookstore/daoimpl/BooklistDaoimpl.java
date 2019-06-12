package com.macoredroid.onlinebookstore.daoimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.repository.BooklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BooklistDaoimpl implements BooklistDao {
    @Autowired
    private BooklistRepository BooklistRepository;
    @Override
    public Booklist findOne(Integer id) {
        return BooklistRepository.findById(id).get();
    }

    @Override
    public Booklist findByIsbn(String isbn) {
        return BooklistRepository.findByIsbn(isbn);
    }


    @Override
    public List<Booklist> findAll() {
        return BooklistRepository.findAll();
    }

    @Override
    public void save(Booklist booklist) {
        BooklistRepository.save(booklist);
    }
}
