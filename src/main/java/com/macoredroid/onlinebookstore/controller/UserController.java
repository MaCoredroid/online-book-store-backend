package com.macoredroid.onlinebookstore.controller;

import com.macoredroid.onlinebookstore.CustomerizedLogger;
import com.macoredroid.onlinebookstore.info.Admininfo;
import com.macoredroid.onlinebookstore.info.Userinfo;
import com.macoredroid.onlinebookstore.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;


@RestController
public class UserController {
    @Autowired
    WebApplicationContext applicationContext;

    private AtomicInteger c = new AtomicInteger(0);


    @GetMapping(value="/counter")
    public int counter() throws IOException {
        CustomerizedLogger customerizedLogger =applicationContext.getBean(CustomerizedLogger.class);
        customerizedLogger.writeLog("count once!");
        return c.get();

    }



    @GetMapping(value ="/login/{username}/password/{password}")
    @ResponseBody
    public String findUser(HttpServletResponse response,@PathVariable("username") String username, @PathVariable("password") String password)
    {
        c.incrementAndGet();
        LoginService loginService=applicationContext.getBean(LoginService.class);
        System.out.println(loginService);
        response.addHeader("Access-Control-Allow-Credentials", "true");
        return loginService.Login(username, password);
    }


    @GetMapping(value ="/register/username/{username}/password/{password}/email/{email}/star/{star}")
    public Boolean RegisterUser(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("email") String email,@PathVariable("star") String star)
    {
        LoginService loginService=applicationContext.getBean(LoginService.class);
        RegisterService registerService=applicationContext.getBean(RegisterService.class);
        if(!loginService.findDuplicateUsername(username))
        {
            return (registerService.Register(username, password, email, Integer.parseInt(star)));
        }
        else
        {
            return false;
        }
    }


    @GetMapping(value ="/loginwithoutverify")
    public Boolean LoginWithoutVerify(HttpServletResponse response)
    {
        LoginService loginService=applicationContext.getBean(LoginService.class);
        System.out.println(loginService);
        response.addHeader("Access-Control-Allow-Credentials", "true");
        return loginService.LoginWithoutVerify();
    }


    @GetMapping(value ="/registeradmin/username/{username}/password/{password}/email/{email}")
    public Boolean RegisterAdmin(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("email") String email)
    {
        LoginService loginService=applicationContext.getBean(LoginService.class);
        RegisterService registerService=applicationContext.getBean(RegisterService.class);
        if(!loginService.findDuplicateUsername(username))
        {
            return registerService.AdminRegister(username,password,email);
        }
        else
        {
            return false;
        }
    }


    @GetMapping(value="/userprofile/username/{username}")
    public Userinfo GetUserProfile(@PathVariable("username") String username)
    {
        GetUserProfileService getUserProfileService=applicationContext.getBean(GetUserProfileService.class);
        return getUserProfileService.GetUserProfile(username);
    }


    @GetMapping(value="/adminprofile/username/{username}")
    public Admininfo GetAdminProfile(@PathVariable("username") String username)
    {
        GetUserProfileService getUserProfileService=applicationContext.getBean(GetUserProfileService.class);
        return getUserProfileService.GetAdminProfile(username);
    }


    @GetMapping(value="/userprofile/change/username/{username}/newusername/{newusername}")
    public boolean ChangeUsername(@PathVariable("username") String username,@PathVariable("newusername") String newusername)
    {
        LoginService loginService=applicationContext.getBean(LoginService.class);
        ChangeUserService changeUserService=applicationContext.getBean(ChangeUserService.class);
        if(!loginService.findDuplicateUsername(newusername))
        {
            return changeUserService.ChangeUsername(username, newusername);
        }
        else
        {
            return false;
        }

    }

    @GetMapping(value="/adminprofile/change/username/{username}/newusername/{newusername}")
    public boolean ChangeAdminUsername(@PathVariable("username") String username,@PathVariable("newusername") String newusername)
    {
        LoginService loginService=applicationContext.getBean(LoginService.class);
        ChangeUserService changeUserService=applicationContext.getBean(ChangeUserService.class);
        if(!loginService.findDuplicateUsername(newusername))
        {
            return changeUserService.ChangeAdminUsername(username, newusername);
        }
        else
        {
            return false;
        }

    }

    @GetMapping(value="/userprofile/change/username/{username}/newemail/{newemail}")
    public boolean ChangeUserEmail(@PathVariable("username") String username,@PathVariable("newemail") String newemail)
    {
        ChangeUserService changeUserService=applicationContext.getBean(ChangeUserService.class);
        return changeUserService.ChangeEmail(username,newemail);
    }


    @GetMapping(value="/userprofile/change/username/{username}/newpassword/{newpassword}")
    public boolean ChangeUserPassword(@PathVariable("username") String username,@PathVariable("newpassword") String newpassword)
    {
        ChangeUserService changeUserService=applicationContext.getBean(ChangeUserService.class);
        return changeUserService.ChangePassword(username, newpassword);
    }


    @GetMapping(value="/adminprofile/change/username/{username}/newpassword/{newpassword}")
    public boolean ChangeAdminPassword(@PathVariable("username") String username,@PathVariable("newpassword") String newpassword)
    {
        ChangeUserService changeUserService=applicationContext.getBean(ChangeUserService.class);
        return changeUserService.ChangeAdminPassword(username, newpassword);
    }


    @GetMapping(value="/admin/seeAllUser")
    public List<Userinfo> SeeAllUsers()
    {
        SeeAllUsers seeAllUsers=applicationContext.getBean(SeeAllUsers.class);
        return seeAllUsers.SeeAllUsers();
    }


    @GetMapping(value="/userprofile/unsubscribe/username/{username}")
    public boolean Unsubscribe(@PathVariable("username") String username)
    {
        UnsubscribeService unsubscribeService=applicationContext.getBean(UnsubscribeService.class);
        return unsubscribeService.Unsubscribe(username);
    }


    @GetMapping(value="/admin/block/{username}")
    public boolean BlockUser(@PathVariable("username") String username)
    {
        BlockUserService blockUserService=applicationContext.getBean(BlockUserService.class);
        return blockUserService.BlockUserService(username);
    }


    @GetMapping(value="/admin/unblock/{username}")
    public boolean UnBlockUser(@PathVariable("username") String username)
    {
        BlockUserService blockUserService=applicationContext.getBean(BlockUserService.class);
        return blockUserService.UnBlockUserService(username);
    }

    @GetMapping(value="/getAllUsername")
    public List<String> getAllUsername()
    {
        FriendService friendService=applicationContext.getBean(FriendService.class);
        return friendService.getAllUsername();
    }

    @GetMapping(value="/beFriendWith/username/{username}/friend/{friend}")
    public boolean beFriendWith(@PathVariable("username") String username,@PathVariable("friend")String friend)
    {
        FriendService friendService=applicationContext.getBean(FriendService.class);
        return friendService.beFriendWith(username, friend);
    }

    @GetMapping(value="/getFriends/{username}")
    public List<String> getFriends(@PathVariable("username") String username)
    {
        FriendService friendService=applicationContext.getBean(FriendService.class);
        return friendService.getFriends(username);
    }




}
