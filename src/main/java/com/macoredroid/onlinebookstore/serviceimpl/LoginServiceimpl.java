package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.AdminDao;
import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.Admin;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceimpl implements LoginService {
    @Autowired
    private UserDao UserDao;
    @Autowired
    private AdminDao AdminDao;

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
