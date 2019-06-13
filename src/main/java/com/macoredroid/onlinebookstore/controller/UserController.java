package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.info.Userinfo;
import com.macoredroid.onlinebookstore.service.ChangeUserService;
import com.macoredroid.onlinebookstore.service.GetUserProfileService;
import com.macoredroid.onlinebookstore.service.LoginService;
import com.macoredroid.onlinebookstore.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private LoginService LoginService;
    @Autowired
    private RegisterService RegisterService;
    @Autowired
    private GetUserProfileService GetUserProfileService;
    @Autowired
    private ChangeUserService ChangeUserService;
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
    @GetMapping(value ="/register/username/{username}/password/{password}/email/{email}/star/{star}")
    public Boolean RegisterUser(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("email") String email,@PathVariable("star") String star)
    {

        if(RegisterService.Register(username,password,email,Integer.parseInt(star)))
        {
            return true;
        }
        return false;
    }
    @GetMapping(value="/userprofile/username/{username}")
    public Userinfo GetUserProfile(@PathVariable("username") String username)
    {
        return GetUserProfileService.GetUserProfile(username);
    }
    @GetMapping(value="/userprofile/change/username/{username}/newusername/{newusername}")
    public boolean ChangeUsername(@PathVariable("username") String username,@PathVariable("newusername") String newusername)
    {
        if(LoginService.findbyUsername(username)!=null)
        {
            if(LoginService.findbyUsername(newusername)==null)
            {
                return ChangeUserService.ChangeUsername(username, newusername);
            }
            else
            {
                return false;
            }
        }
        return false;
    }
    @GetMapping(value="/userprofile/change/username/{username}/newemail/{newemail}")
    public boolean ChangeUserEmail(@PathVariable("username") String username,@PathVariable("newemail") String newemail)
    {
        return ChangeUserService.ChangeEmail(username,newemail);
    }



}
