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
        return  GetOrderService.findAllByUsername(username);
    }
    @GetMapping(value="/order/removeorder/{id}")
    public boolean RemoveOrder(@PathVariable("id") String id)
    {
        return RemoveFromOrderService.RemoveFromOrder(Integer.parseInt(id));
    }
    @GetMapping(value="/order/clearall/username/{username}/username/{username}")
    public boolean clearAll(@PathVariable("username") String username)
    {
         List<Orderinfo> Orders= GetOrderService.findAllByUsername(username);
         for(Orderinfo tempOrder:Orders)
         {
             if(RemoveFromOrderService.RemoveFromOrder(Integer.parseInt(tempOrder.OrderID)))
             {

             }
             else
             {
                 return false;
             }
         }
         return true;
    }

}
