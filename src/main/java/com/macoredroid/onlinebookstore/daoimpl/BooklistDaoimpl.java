package com.macoredroid.onlinebookstore.daoimpl;

import com.alibaba.fastjson.JSONArray;
import com.macoredroid.onlinebookstore.dao.BooklistDao;
import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.entity.Cover;
import com.macoredroid.onlinebookstore.repository.BooklistRepository;
import com.macoredroid.onlinebookstore.repository.CoverRepository;
import com.macoredroid.onlinebookstore.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Stream;

@Repository
public class BooklistDaoimpl implements BooklistDao {
    @Autowired
    private BooklistRepository BooklistRepository;
    @Autowired
    private CoverRepository  CoverRepository;
    @Autowired
    RedisUtil redisUtil;
    @Override
    public Booklist findOne(Integer id) {
        Booklist booklist=null;
        System.out.println("Searching Book: " + id + " in Redis");
        Object b = redisUtil.get("book" + id);
        if(b==null)
        {
            System.out.println("Book: " + id + " is not in Redis");
            System.out.println("Searching Book: " + id + " in DB");
            booklist=BooklistRepository.findById(id).get();
            redisUtil.set("book" + id, JSONArray.toJSON(booklist));
        }
        else
        {
            booklist = JSONArray.parseObject(b.toString(), Booklist.class);
            System.out.println("Book: " + id + " is in Redis");
        }
        return booklist;
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
    public String getDescriptionByBookId(String BookId) {
        if(BookId.equals("1000") || BookId.equals("1001") || BookId.equals("1002"))
        {
            StringBuilder contentBuilder = new StringBuilder();
            try (Stream<String> stream = Files.lines( Paths.get("./src/main/resources/"+BookId+".txt"), StandardCharsets.UTF_8))
            {
                stream.forEach(s -> contentBuilder.append(s).append("\n"));
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return contentBuilder.toString();
        }
        else
        {
            return "No description provided";
        }
    }

    @Override
    public String searchInDescription(String word) {
        return "hhh";
    }

    @Override
    public void save(Booklist booklist) {
        redisUtil.set("book" + booklist.getBooklistID(), JSONArray.toJSON(booklist));
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
