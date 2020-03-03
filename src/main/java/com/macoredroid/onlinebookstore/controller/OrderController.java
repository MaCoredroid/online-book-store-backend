package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.info.Orderinfo;
import com.macoredroid.onlinebookstore.service.GetOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    WebApplicationContext applicationContext;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value ="/order/getorder/{username}")
    public List<Orderinfo> findUser(@PathVariable("username") String username) {
        GetOrderService getOrderService=applicationContext.getBean(GetOrderService.class);
        return  getOrderService.findAllByUsername(username);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value ="/order/id/{id}")
    public Orderinfo findByID(@PathVariable("id") String id)
    {
        GetOrderService getOrderService=applicationContext.getBean(GetOrderService.class);
        return  getOrderService.findOne(Integer.parseInt(id));
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/admin/seeAllOrder")
    public List<Orderinfo> findAllOrder()
    {
        GetOrderService getOrderService=applicationContext.getBean(GetOrderService.class);
        return getOrderService.findAll();
    }




}
