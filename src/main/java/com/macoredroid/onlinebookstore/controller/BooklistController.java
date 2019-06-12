package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.info.bookinfo;
import com.macoredroid.onlinebookstore.service.BooklistService;
import com.macoredroid.onlinebookstore.service.DirectlyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    @GetMapping(value = "/findEvent/{id}")
    public Booklist findEvent(@PathVariable("id") Integer id) {
        System.out.println("Searching Book: " + id);
        return BooklistService.findBookByID(id);
    }
    @GetMapping(value="/Booklist/{isbn}")
    public bookinfo findbyIsbn(@PathVariable("isbn") String isbn)
    {
        isbn=isbn.replaceAll("[^\\x00-\\x7F]", "");
        System.out.println("Print book by isbn:");
        return BooklistService.findByIsbn(isbn);

    }
    @GetMapping(value="/booklist")
    public List<bookinfo> findAll()
    {
        return BooklistService.findAll();

    }
    @GetMapping(value="/isbnlist")
    public List<String> findAllisbn()
    {
        System.out.println("Print all books:");
        List<bookinfo> temp=BooklistService.findAll();
        List<String> isbnlist=new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
           isbnlist.add(temp.get(i).isbn);
        }
        return isbnlist;

    }
    @GetMapping(value="/booklist/diredtlyOrder/username/{username}/isbn/{isbn}/number/{number}/time/{time}")
    public boolean directOrder(@PathVariable("username") String username,@PathVariable("isbn") String isbn,@PathVariable("number") String number,@PathVariable("time") String time)
    {
        return DirectlyOrderService.DirectlyOrder(username, isbn, number, time);
    }


}
