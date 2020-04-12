package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.info.bookinfo;
import com.macoredroid.onlinebookstore.service.BooklistService;
import com.macoredroid.onlinebookstore.service.ChangeBookService;
import com.macoredroid.onlinebookstore.service.DirectlyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import java.rmi.RemoteException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class BooklistController {
    @Autowired
    WebApplicationContext applicationContext;


    @GetMapping(value="/Booklist/{id}")
    public bookinfo findbyId(@PathVariable("id") String id) throws RemoteException {
        BooklistService booklistService=applicationContext.getBean(BooklistService.class);
        return booklistService.findBookByID(Integer.parseInt(id));

    }

    @GetMapping(value="/booklist")
    public List<bookinfo> findAll() throws RemoteException {
        BooklistService booklistService=applicationContext.getBean(BooklistService.class);
        return booklistService.findAll();

    }

    @GetMapping(value="/userbooklist")
    public List<bookinfo> UserfindAll() throws RemoteException {
        BooklistService booklistService=applicationContext.getBean(BooklistService.class);
        return booklistService.UserfindAll();

    }

    @GetMapping(value="/bookidlist")
    public List<String> findAllbookid() throws RemoteException {
        BooklistService booklistService=applicationContext.getBean(BooklistService.class);
        return booklistService.findAllbookid();

    }


    @GetMapping(value="/userbookidlist")
    public List<String> userfindAllbookid() throws RemoteException {
        BooklistService booklistService=applicationContext.getBean(BooklistService.class);
        return booklistService.userfindAllbookid();

    }

    @GetMapping(value="/booklist/diredtlyOrder/username/{username}/isbn/{isbn}/number/{number}/time/{time}")
    public boolean directOrder(@PathVariable("username") String username,@PathVariable("isbn") String isbn,@PathVariable("number") String number,@PathVariable("time") String time)
    {
        DirectlyOrderService directlyOrderService=applicationContext.getBean(DirectlyOrderService.class);
        return directlyOrderService.DirectlyOrder(username, isbn, number, time);
    }


    @GetMapping(value="/admin/change/bookID/{bookID}/newbookname/{newbookname}")
    public boolean changeName(@PathVariable("bookID") String bookID,@PathVariable("newbookname") String newbookname)
    {
        ChangeBookService changeBookService=applicationContext.getBean(ChangeBookService.class);
        return changeBookService.changeName(bookID, newbookname);
    }

    @GetMapping(value="/admin/change/bookID/{bookID}/newbookprice/{newbookprice}")
    public boolean changePrice(@PathVariable("bookID") String bookID,@PathVariable("newbookprice") String newbookprcie)
    {
        ChangeBookService changeBookService=applicationContext.getBean(ChangeBookService.class);
        return changeBookService.changePrice(bookID, newbookprcie);
    }

    @GetMapping(value="/admin/change/bookID/{bookID}/newauthorname/{newauthorname}")
    public boolean changeAuthor(@PathVariable("bookID") String bookID,@PathVariable("newauthorname") String newauthorname)
    {
        ChangeBookService changeBookService=applicationContext.getBean(ChangeBookService.class);
        return changeBookService.changeAuthor(bookID, newauthorname);
    }

    @GetMapping(value="/admin/change/bookID/{bookID}/newstock/{newstock}")
    public boolean changeStock(@PathVariable("bookID") String bookID,@PathVariable("newstock") String newstock)
    {
        ChangeBookService changeBookService=applicationContext.getBean(ChangeBookService.class);
        return changeBookService.changeStock(bookID, newstock);
    }

    @GetMapping(value="/admin/change/bookID/{bookID}/newisbn/{newisbn}")
    public boolean changeIsbn(@PathVariable("bookID") String bookID,@PathVariable("newisbn") String newisbn)
    {
        ChangeBookService changeBookService=applicationContext.getBean(ChangeBookService.class);
        return changeBookService.changeIsbn(bookID, newisbn);
    }

    @GetMapping(value="/admin/blockbook/bookID/{bookID}")
    public boolean BlockBook(@PathVariable("bookID") String bookID) throws RemoteException {
        BooklistService booklistService=applicationContext.getBean(BooklistService.class);
        return booklistService.block(bookID);
    }

    @GetMapping(value="/admin/unblockbook/bookID/{bookID}")
    public boolean UnblockBook(@PathVariable("bookID") String bookID) throws RemoteException {
        BooklistService booklistService=applicationContext.getBean(BooklistService.class);
        return booklistService.unblock(bookID);
    }

    @GetMapping(value="/admin/addbook/name/{name}/author/{author}/price/{price}/isbn/{isbn}/stock/{stock}")
    @ResponseBody
    public String AddBook(@PathVariable("name") String name,@PathVariable("author") String author,@PathVariable("price") String price,@PathVariable("isbn") String isbn,@PathVariable("stock") String stock) throws RemoteException {
        BooklistService booklistService=applicationContext.getBean(BooklistService.class);
        return booklistService.NewBook(name,author,Integer.parseInt(price),isbn,Integer.parseInt(stock));
    }

    @GetMapping(value="/admin/deletebook/bookid/{bookid}")
    public boolean DeleteBook(@PathVariable("bookid") String bookid) throws RemoteException {
        BooklistService booklistService=applicationContext.getBean(BooklistService.class);
        return booklistService.DeleteBook(bookid);
    }

    @GetMapping(value="/getDescriptionByBookId/bookid/{bookid}")
    public String getDescriptionByBookId(@PathVariable("bookid") String bookid) throws RemoteException {
        BooklistService booklistService=applicationContext.getBean(BooklistService.class);
        return booklistService.getDescriptionByBookId(bookid);
    }

    @GetMapping(value="/searchInDescription/pattern/{pattern}")
    public String searchInDescription(@PathVariable("pattern") String pattern) throws Exception {
        BooklistService booklistService=applicationContext.getBean(BooklistService.class);
        return booklistService.searchInDescription(pattern);
    }



}
