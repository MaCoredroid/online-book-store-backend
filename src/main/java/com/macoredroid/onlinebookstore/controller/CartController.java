package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.info.Cartinfo;
import com.macoredroid.onlinebookstore.service.GetCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CartController {
    @Autowired
    private GetCartService GetCartService;
    @GetMapping(value ="/cart/{username}")
    public List<Cartinfo> findUser(@PathVariable("username") String username)
    {
        System.out.println("User Tried to get carts: "+username);
        return  GetCartService.findAllByUsername(username);
    }

}
