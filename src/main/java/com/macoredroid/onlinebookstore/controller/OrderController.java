package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.info.Orderinfo;
import com.macoredroid.onlinebookstore.service.GetOrderService;
import com.macoredroid.onlinebookstore.service.RemoveFromOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class OrderController {
    @Autowired
    private GetOrderService GetOrderService;
    @Autowired
    private RemoveFromOrderService RemoveFromOrderService;
    @GetMapping(value ="/order/getorder/{username}")
    public List<Orderinfo> findUser(@PathVariable("username") String username)
    {
        System.out.println("User Tried to get orders: "+username);
        return  GetOrderService.findAllByUsername(username);
    }
    @GetMapping(value="/order/removeorder/{id}")
    public boolean RemoveOrder(@PathVariable("id") String id)
    {
        System.out.println("Order will be removed:"+id);
        return RemoveFromOrderService.RemoveFromOrder(Integer.parseInt(id));
    }

}
