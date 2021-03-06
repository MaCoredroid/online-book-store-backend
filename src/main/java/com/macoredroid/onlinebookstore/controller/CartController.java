package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.PurchaseConsumer;
import com.macoredroid.onlinebookstore.info.Cartinfo;
import com.macoredroid.onlinebookstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;


@RestController
public class CartController {
    @Autowired
    WebApplicationContext applicationContext;


    @GetMapping(value ="/cart/username/{username}")
    public List<Cartinfo> findCartsByUsername(@PathVariable("username") String username)
    {
        GetCartService getCartService=applicationContext.getBean(GetCartService.class);
        return  getCartService.findAllByUsername(username);
    }


    @GetMapping(value ="/cart/cartid/{id}")
    public Cartinfo findCartById(@PathVariable("id") String id)
    {
        GetCartService getCartService=applicationContext.getBean(GetCartService.class);
        return  getCartService.findOne(Integer.parseInt(id));
    }

    @GetMapping(value ="/cart/username/{username}/isbn/{isbn}/number/{number}/time/{time}")
    public boolean addtoCart(@PathVariable("username") String username,@PathVariable("isbn") String isbn,@PathVariable("number") String number,@PathVariable("time") String time)
    {
        AddtoCartService addtoCartService=applicationContext.getBean(AddtoCartService.class);
        return addtoCartService.AddtoCart(time, Integer.parseInt(number), isbn, username);
    }

    @GetMapping(value="/cart/remove/{id}")
    public boolean removefromCart(@PathVariable("id") String id)
    {
        RemoveFromCartService removeFromCartService=applicationContext.getBean(RemoveFromCartService.class);
        return removeFromCartService.RemoveFromCart(Integer.parseInt(id));
    }

    @GetMapping(value="/cart/change/{id}/number/{number}")
    public boolean changeCart(@PathVariable("id") String id,@PathVariable("number") String number)
    {
        ChangeCartService changeCartService=applicationContext.getBean(ChangeCartService.class);
        return changeCartService.ChangeCart(Integer.parseInt(id), Integer.parseInt(number));
    }

    @GetMapping(value="/cart/purchase/{id}/time/{time}")
    public ResponseEntity<?> purchaseCart(@PathVariable("id") String id, @PathVariable("time") String time)
    {
        PurchaseProducerService purchaseProducerService =applicationContext.getBean(PurchaseProducerService.class);;
        return new ResponseEntity<>(purchaseProducerService.Purchase(Integer.parseInt(id), time), HttpStatus.OK);
    }

    @GetMapping(value="/cart/innerpurchase/{id}/time/{time}")
    public boolean innerpurchaseCart(@PathVariable("id") String id,@PathVariable("time") String time)
    {
        PurchaseConsumerService purchaseConsumerService =applicationContext.getBean(PurchaseConsumerService.class);;
        return purchaseConsumerService.Purchase(Integer.parseInt(id), time);
    }

    @GetMapping(value="/cart/clearall/username/{username}/username/{username}")
    public boolean clearAll(@PathVariable("username") String username)
    {
        GetCartService getCartService=applicationContext.getBean(GetCartService.class);
        RemoveFromCartService removeFromCartService=applicationContext.getBean(RemoveFromCartService.class);
        List<Cartinfo> Carts = getCartService.findAllByUsername(username);
        for(Cartinfo tempCart:Carts)
        {
            if(!removeFromCartService.RemoveFromCart(Integer.parseInt(tempCart.CartID))) {
                return false;
            }
        }
        return true;
    }

    @GetMapping(value="/admin/seeAllCart")
    public List<Cartinfo> findAllCart()
    {
        GetCartService getCartService=applicationContext.getBean(GetCartService.class);
        return getCartService.findAll();
    }

}
