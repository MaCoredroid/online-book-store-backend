package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.info.Orderinfo;
import com.macoredroid.onlinebookstore.service.GetOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    private GetOrderService GetOrderService;
    @GetMapping(value ="/order/{username}")
    public List<Orderinfo> findUser(@PathVariable("username") String username)
    {
        System.out.println("User Tried to get orders: "+username);
        return  GetOrderService.findAllByUsername(username);
    }

}
