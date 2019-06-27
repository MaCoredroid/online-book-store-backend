package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.AdminDao;
import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterServiceimpl implements RegisterService {
    @Autowired
    private UserDao UserDao;
    @Autowired
    private AdminDao AdminDao;
    @Override
    public boolean Register(String username, String password, String email, int star) {


            UserDao.save(username,password,email,star);
            return true;

    }

    @Override
    public boolean AdminRegister(String username, String password, String email) {
        AdminDao.save(username, password, email);
        return true;
    }
}
