package com.macoredroid.onlinebookstore.controller;
import com.macoredroid.onlinebookstore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class LoginController {
    @Autowired
    private LoginService LoginService;
    @GetMapping(value ="/login/{username}/password/{password}")
    public Boolean findUser(@PathVariable("username") String username, @PathVariable("password") String password)
    {
        if(LoginService.findbyUsername(username)!=null)
        {
            if(LoginService.findbyUsername(username).getPassword().equals(password))
            {
                return true;
            }
        }
        return false;
    }


}
