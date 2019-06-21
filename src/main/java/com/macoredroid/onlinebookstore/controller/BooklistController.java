package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.info.bookinfo;
import com.macoredroid.onlinebookstore.service.BooklistService;
import com.macoredroid.onlinebookstore.service.DirectlyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BooklistController {
    @Autowired
    private BooklistService BooklistService;
    @Autowired
    private DirectlyOrderService DirectlyOrderService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value = "/findEvent/{id}")
    public Booklist findEvent(@PathVariable("id") Integer id)
    {
        return BooklistService.findBookByID(id);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/Booklist/{isbn}")
    public bookinfo findbyIsbn(@PathVariable("isbn") String isbn)
    {
        isbn=isbn.replaceAll("[^\\x00-\\x7F]", "");
        return BooklistService.findByIsbn(isbn);

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/booklist")
    public List<bookinfo> findAll()
    {
        return BooklistService.findAll();

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/isbnlist")
    public List<String> findAllisbn()
    {
        List<bookinfo> temp=BooklistService.findAll();
        List<String> isbnlist=new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
           isbnlist.add(temp.get(i).isbn);
        }
        return isbnlist;

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/booklist/diredtlyOrder/username/{username}/isbn/{isbn}/number/{number}/time/{time}")
    public boolean directOrder(@PathVariable("username") String username,@PathVariable("isbn") String isbn,@PathVariable("number") String number,@PathVariable("time") String time)
    {
        return DirectlyOrderService.DirectlyOrder(username, isbn, number, time);
    }


}
