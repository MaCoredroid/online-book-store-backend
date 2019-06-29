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
    @GetMapping(value="/userbooklist")
    public List<bookinfo> UserfindAll()
    {
        return BooklistService.UserfindAll();

    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/bookidlist")
    public List<String> findAllbookid()
    {
        return BooklistService.findAllbookid();

    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/userbookidlist")
    public List<String> userfindAllbookid()
    {
        return BooklistService.userfindAllbookid();

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
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/admin/change/bookID/{bookID}/newauthorname/{newauthorname}")
    public boolean changeAuthor(@PathVariable("bookID") String bookID,@PathVariable("newauthorname") String newauthorname)
    {
        return ChangeBookService.changeAuthor(bookID, newauthorname);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/admin/change/bookID/{bookID}/newstock/{newstock}")
    public boolean changeStock(@PathVariable("bookID") String bookID,@PathVariable("newstock") String newstock)
    {
        return ChangeBookService.changeStock(bookID, newstock);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/admin/change/bookID/{bookID}/newisbn/{newisbn}")
    public boolean changeIsbn(@PathVariable("bookID") String bookID,@PathVariable("newisbn") String newisbn)
    {
        return ChangeBookService.changeIsbn(bookID, newisbn);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/admin/blockbook/bookID/{bookID}")
    public boolean BlockBook(@PathVariable("bookID") String bookID)
    {
        return BooklistService.block(bookID);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/admin/unblockbook/bookID/{bookID}")
    public boolean UnblockBook(@PathVariable("bookID") String bookID)
    {
        return BooklistService.unblock(bookID);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/admin/addbook/name/{name}/author/{author}/price/{price}/isbn/{isbn}/stock/{stock}")
    public boolean AddBook(@PathVariable("name") String name,@PathVariable("author") String author,@PathVariable("price") String price,@PathVariable("isbn") String isbn,@PathVariable("stock") String stock)
    {
        return BooklistService.NewBook(name,author,Integer.parseInt(price),isbn,Integer.parseInt(stock));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/admin/deletebook/bookid/{bookid}")
    public boolean DeleteBook(@PathVariable("bookid") String bookid)
    {
        return BooklistService.DeleteBook(bookid);
    }



}
