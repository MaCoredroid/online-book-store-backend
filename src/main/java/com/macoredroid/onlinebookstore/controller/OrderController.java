package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.entity.Order;
import com.macoredroid.onlinebookstore.service.GetOrderService;
import com.macoredroid.onlinebookstore.service.GetSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    private GetOrderService GetOrderService;
    private GetSalesService GetSalesService;
    @GetMapping(value ="/order/{username}")
    public List<Order> findUser(@PathVariable("username") String username)
    {
        System.out.println("User Tried to get orders: "+username);
        return  GetOrderService.findAllByUsername(username);
    }

}
