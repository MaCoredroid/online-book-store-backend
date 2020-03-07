package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.AdminDao;
import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.Admin;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("session")
public class LoginServiceimpl implements LoginService {
    @Autowired
    private UserDao UserDao;
    @Autowired
    private AdminDao AdminDao;

    private boolean isLogin=false;

    @Override
    public Boolean LoginWithoutVerify() {
        return isLogin;
    }

    @Override
    public String Login(String username, String password) {

        User tempUser=UserDao.findOne(username);
        if(tempUser==null)
        {
            Admin tempAdmin=AdminDao.findOne(username);
            if(tempAdmin==null)
            {
                return "false";
            }
            else
            {
                if(tempAdmin.getPassword().equals(password))
                {
                    isLogin=true;
                    return "Admin";
                }
                else
                {
                    return "false";
                }

            }
        }
        else
        {
            if(tempUser.getStar()==-1)
            {
                return "Blocked";
            }
            else
            {
                if (tempUser.getPassword().equals(password)) {
                    isLogin=true;
                    return "User";
                } else {
                    return "false";
                }
            }
        }
    }

    @Override
    public boolean findDuplicateUsername(String username) {
        User tempUser=UserDao.findOne(username);
        if(tempUser==null)
        {
            Admin tempAdmin=AdminDao.findOne(username);
            if(tempAdmin==null)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        else
        {
            return true;
        }
    }
}
