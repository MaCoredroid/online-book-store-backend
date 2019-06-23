package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.info.Orderinfo;
import com.macoredroid.onlinebookstore.service.GetOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    private GetOrderService GetOrderService;
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value ="/order/getorder/{username}")
    public List<Orderinfo> findUser(@PathVariable("username") String username)
    {
        return  GetOrderService.findAllByUsername(username);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/admin/seeAllOrder")
    public List<Orderinfo> findAllOrder()
    {
        return GetOrderService.findAll();
    }


}
