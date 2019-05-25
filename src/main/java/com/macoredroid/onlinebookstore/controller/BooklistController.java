package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.entity.Booklist;
import com.macoredroid.onlinebookstore.service.BooklistService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class BooklistController {
    @Autowired
    private BooklistService BooklistService;
    @GetMapping(value = "/findEvent/{id}")
    public Booklist findEvent(@PathVariable("id") Integer id) {
        System.out.println("Searching Book: " + id);
        return BooklistService.findBookByID(id);
    }

}
