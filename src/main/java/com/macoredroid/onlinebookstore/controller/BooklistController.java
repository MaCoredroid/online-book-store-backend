package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.info.bookinfo;
import com.macoredroid.onlinebookstore.service.BooklistService;
import com.macoredroid.onlinebookstore.service.ChangeBookService;
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
    private ChangeBookService ChangeBookService;
    @Autowired
    private DirectlyOrderService DirectlyOrderService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/Booklist/{id}")
    public bookinfo findbyId(@PathVariable("id") String id)
    {
        return BooklistService.findBookByID(Integer.parseInt(id));

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/booklist")
    public List<bookinfo> findAll()
    {
        return BooklistService.findAll();

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/bookidlist")
    public List<String> findAllbookid()
    {
        List<bookinfo> temp=BooklistService.findAll();
        List<String> bookidlist=new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            bookidlist.add(Integer.toString(temp.get(i).booklistID));
        }
        return bookidlist;

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/booklist/diredtlyOrder/username/{username}/isbn/{isbn}/number/{number}/time/{time}")
    public boolean directOrder(@PathVariable("username") String username,@PathVariable("isbn") String isbn,@PathVariable("number") String number,@PathVariable("time") String time)
    {
        return DirectlyOrderService.DirectlyOrder(username, isbn, number, time);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/admin/change/bookID/{bookID}/newbookname/{newbookname}")
    public boolean changeName(@PathVariable("bookID") String bookID,@PathVariable("newbookname") String newbookname)
    {
        return ChangeBookService.changeName(bookID, newbookname);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/admin/change/bookID/{bookID}/newbookprice/{newbookprice}")
    public boolean changePrice(@PathVariable("bookID") String bookID,@PathVariable("newbookprice") String newbookprcie)
    {
        return ChangeBookService.changePrice(bookID, newbookprcie);
    }



}
