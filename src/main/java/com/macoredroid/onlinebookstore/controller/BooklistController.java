package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.service.BooklistService;
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
    @GetMapping(value = "/findEvent/{id}")
    public Booklist findEvent(@PathVariable("id") Integer id) {
        System.out.println("Searching Book: " + id);
        return BooklistService.findBookByID(id);
    }
    @GetMapping(value="/booklist")
    public List<Booklist> findAll()
    {
        System.out.println("Print all books:");
        return BooklistService.findAll();

    }
    @GetMapping(value="/isbnlist")
    public List<String> findAllisbn()
    {
        System.out.println("Print all books:");
        List<Booklist> temp=BooklistService.findAll();
        List<String> isbnlist=new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
           isbnlist.add(temp.get(i).getIsbn());
        }
        return isbnlist;

    }


}
