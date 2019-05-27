package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceimpl implements RegisterService {
    @Autowired
    private UserDao UserDao;
    @Override
    public boolean Register(String username, String password, String email, int star) {
        User temp= UserDao.findOne(username);
        if(temp!=null)
        {
            return false;
        }
        else
        {
            UserDao.save(username,password,email,star);
            return true;
        }
    }
}
