package com.macoredroid.onlinebookstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RegisterController {
    @Autowired
    private com.macoredroid.onlinebookstore.service.RegisterService RegisterService;
    @GetMapping(value ="/register/username/{username}/password/{password}/email/{email}/star/{star}")
    public Boolean RegisterUser(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("email") String email,@PathVariable("star") String star)
    {
        System.out.println("User Tried to Register: "+username);

        if(RegisterService.Register(username,password,email,Integer.parseInt(star)))
        {
            return true;
        }
        return false;
    }

}