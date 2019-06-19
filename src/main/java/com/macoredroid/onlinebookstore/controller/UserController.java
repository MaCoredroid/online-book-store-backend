package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.info.Userinfo;
import com.macoredroid.onlinebookstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
    @Autowired
    private SeeAllUsers SeeAllUsers;
    @Autowired
    private UnsubscribeService UnsubscribeService;
    @Autowired
    private BlockUserService BlockUserService;
    @GetMapping(value ="/login/{username}/password/{password}")
    @ResponseBody
    public String findUser(@PathVariable("username") String username, @PathVariable("password") String password)
    {
        return LoginService.Login(username, password);
    }
    @GetMapping(value ="/register/username/{username}/password/{password}/email/{email}/star/{star}")
    public Boolean RegisterUser(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("email") String email,@PathVariable("star") String star)
    {
        if(!LoginService.findDuplicateUsername(username))
        {
            return (RegisterService.Register(username, password, email, Integer.parseInt(star)));
        }
        else
        {
            return false;
        }
    }
    @GetMapping(value="/userprofile/username/{username}")
    public Userinfo GetUserProfile(@PathVariable("username") String username)
    {
        return GetUserProfileService.GetUserProfile(username);
    }
    @GetMapping(value="/userprofile/change/username/{username}/newusername/{newusername}")
    public boolean ChangeUsername(@PathVariable("username") String username,@PathVariable("newusername") String newusername)
    {
        if(!LoginService.findDuplicateUsername(username))
        {
            if(!LoginService.findDuplicateUsername(newusername))
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
    @GetMapping(value="/userprofile/change/username/{username}/newpassword/{newpassword}")
    public boolean ChangeUserPassword(@PathVariable("username") String username,@PathVariable("newpassword") String newpassword)
    {
        return ChangeUserService.ChangePassword(username, newpassword);
    }
    @GetMapping(value="/admin/seeAllUser")
    public List<Userinfo> SeeAllUsers()
    {
        return SeeAllUsers.SeeAllUsers();
    }
    @GetMapping(value="/userprofile/unsubscribe/username/{username}")
    public boolean Unsubscribe(@PathVariable("username") String username)
    {
        return UnsubscribeService.Unsubscribe(username);
    }
    @GetMapping(value="/admin/block/{username}")
    public boolean BlockUser(@PathVariable("username") String username)
    {
        return BlockUserService.BlockUserService(username);
    }
    @GetMapping(value="/admin/unblock/{username}")
    public boolean UnBlockUser(@PathVariable("username") String username)
    {
        return BlockUserService.UnBlockUserService(username);
    }




}
