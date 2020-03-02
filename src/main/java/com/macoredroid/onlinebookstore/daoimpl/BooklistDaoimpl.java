package com.macoredroid.onlinebookstore.daoimpl;

import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Cover;
import com.macoredroid.onlinebookstore.repository.BooklistRepository;
import com.macoredroid.onlinebookstore.repository.CoverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BooklistDaoimpl implements BooklistDao {
    @Autowired
    private BooklistRepository BooklistRepository;
    @Autowired
    private CoverRepository  CoverRepository;
    @Override
    public Booklist findOne(Integer id) {
        return BooklistRepository.findById(id).get();
    }

    @Override
    public Booklist findByIsbn(String isbn) {
        return BooklistRepository.findByIsbn(isbn);
    }

    @Override
    public Booklist findByName(String name) {
        return BooklistRepository.findByName(name);
    }


    @Override
    public List<Booklist> findAll() {
        return BooklistRepository.findAll();
    }

    @Override
    public byte[] findCoverBybookid(String bookid) {
        Cover newcover=CoverRepository.findByBookid(bookid);
        if(newcover==null)
        {
            return null;
        }
        else
        {
            return newcover.picture;
        }
    }

    @Override
    public void save(Booklist booklist) {
        BooklistRepository.save(booklist);
    }

    @Override
    public void saveCover(Cover cover)
    {
        CoverRepository.save(cover);
    }

    @Override
    public void deleteOne(Integer id) {
        BooklistRepository.deleteById(id);
    }

    @Override
    public void deleteCover(String id) {
        CoverRepository.deleteById(id);
    }
}
