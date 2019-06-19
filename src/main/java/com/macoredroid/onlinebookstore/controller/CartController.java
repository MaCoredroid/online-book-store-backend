package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.info.Cartinfo;
import com.macoredroid.onlinebookstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CartController {
    @Autowired
    private GetCartService GetCartService;
    @Autowired
    private AddtoCartService AddtoCartService;
    @Autowired
    private RemoveFromCartService RemoveFromCartService;
    @Autowired
    private ChangeCartService ChangeCartService;
    @Autowired
    private PurchaseService PurchaseService;
    @GetMapping(value ="/cart/{username}")
    public List<Cartinfo> findUser(@PathVariable("username") String username)
    {
        return  GetCartService.findAllByUsername(username);
    }
    @GetMapping(value ="/cart/username/{username}/isbn/{isbn}/number/{number}/time/{time}")
    public boolean addtoCart(@PathVariable("username") String username,@PathVariable("isbn") String isbn,@PathVariable("number") String number,@PathVariable("time") String time)
    {
        if(AddtoCartService.AddtoCart(time,Integer.parseInt(number),isbn,username))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @GetMapping(value="/cart/remove/{id}")
       public boolean removefromCart(@PathVariable("id") String id)
    {
        if(RemoveFromCartService.RemoveFromCart(Integer.parseInt(id)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @GetMapping(value="/cart/change/{id}/number/{number}")
    public boolean changeCart(@PathVariable("id") String id,@PathVariable("number") String number)
    {
        if(ChangeCartService.ChangeCart(Integer.parseInt(id),Integer.parseInt(number)))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @GetMapping(value="/cart/purchase/{id}/time/{time}")
    public boolean purchaseCart(@PathVariable("id") String id,@PathVariable("time") String time)
    {
        if(PurchaseService.Purchase(Integer.parseInt(id),time))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    @GetMapping(value="/cart/clearall/username/{username}/username/{username}")
    public boolean clearAll(@PathVariable("username") String username)
    {
        List<Cartinfo> Carts = GetCartService.findAllByUsername(username);
        for(Cartinfo tempCart:Carts)
        {
            if(RemoveFromCartService.RemoveFromCart(Integer.parseInt(tempCart.CartID)))
            {

            }
            else
            {
                return false;
            }
        }
        return true;
    }
    @GetMapping(value="/admin/seeAllCart")
    public List<Cartinfo> findAllCart()
    {
        return GetCartService.findAll();
    }

}
