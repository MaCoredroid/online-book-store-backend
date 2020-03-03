package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.info.Cartinfo;
import com.macoredroid.onlinebookstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
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

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value ="/cart/username/{username}")
    public List<Cartinfo> findCartsByUsername(@PathVariable("username") String username)
    {
        GetCartService getCartService=applicationContext.getBean(GetCartService.class);
        return  getCartService.findAllByUsername(username);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value ="/cart/cartid/{id}")
    public Cartinfo findCartById(@PathVariable("id") String id)
    {
        GetCartService getCartService=applicationContext.getBean(GetCartService.class);
        return  getCartService.findOne(Integer.parseInt(id));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value ="/cart/username/{username}/isbn/{isbn}/number/{number}/time/{time}")
    public boolean addtoCart(@PathVariable("username") String username,@PathVariable("isbn") String isbn,@PathVariable("number") String number,@PathVariable("time") String time)
    {
        AddtoCartService addtoCartService=applicationContext.getBean(AddtoCartService.class);
        return addtoCartService.AddtoCart(time, Integer.parseInt(number), isbn, username);
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/cart/remove/{id}")
    public boolean removefromCart(@PathVariable("id") String id)
    {
        RemoveFromCartService removeFromCartService=applicationContext.getBean(RemoveFromCartService.class);
        return removeFromCartService.RemoveFromCart(Integer.parseInt(id));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/cart/change/{id}/number/{number}")
    public boolean changeCart(@PathVariable("id") String id,@PathVariable("number") String number)
    {
        ChangeCartService changeCartService=applicationContext.getBean(ChangeCartService.class);
        return changeCartService.ChangeCart(Integer.parseInt(id), Integer.parseInt(number));
    }
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/cart/purchase/{id}/time/{time}")
    public boolean purchaseCart(@PathVariable("id") String id,@PathVariable("time") String time)
    {
        PurchaseService purchaseService=applicationContext.getBean(PurchaseService.class);;
        return purchaseService.Purchase(Integer.parseInt(id), time);
    }
    @CrossOrigin(origins = "http://localhost:3000")
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
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value="/admin/seeAllCart")
    public List<Cartinfo> findAllCart()
    {
        GetCartService getCartService=applicationContext.getBean(GetCartService.class);
        return getCartService.findAll();
    }

}
