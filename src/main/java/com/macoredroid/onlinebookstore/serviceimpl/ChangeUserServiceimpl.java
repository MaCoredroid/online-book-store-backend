package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.AdminDao;
import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.Admin;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.service.ChangeUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChangeUserServiceimpl implements ChangeUserService {
    @Autowired
    UserDao UserDao;
    @Autowired
    AdminDao AdminDao;
    @Override
    public boolean ChangeUsername(String username, String newusername) {
        User tempUser= UserDao.findOne(username);
        if(tempUser==null)
        {
            return false;
        }
        tempUser.setUsername(newusername);
        UserDao.save(tempUser);
        return true;
    }

    @Override
    public boolean ChangeAdminUsername(String username, String newusername) {
        Admin tempAdmin= AdminDao.findOne(username);
        if(tempAdmin==null)
        {
            return false;
        }
        tempAdmin.setUsername(newusername);
        AdminDao.save(tempAdmin);
        return true;
    }

    @Override
    public boolean ChangeAdminPassword(String username, String newpassword) {
        Admin tempAdmin= AdminDao.findOne(username);
        if(tempAdmin==null)
        {
            return false;
        }
        tempAdmin.setPassword(newpassword);
        AdminDao.save(tempAdmin);
        return true;
    }

    @Override
    public boolean ChangeEmail(String username, String newemail) {
        User tempUser= UserDao.findOne(username);
        if(tempUser==null)
        {
            return false;
        }
        tempUser.setEmail(newemail);
        UserDao.save(tempUser);
        return true;
    }

    @Override
    public boolean ChangePassword(String username, String newpassword) {
        User tempUser= UserDao.findOne(username);
        if(tempUser==null)
        {
            return false;
        }
        tempUser.setPassword(newpassword);
        UserDao.save(tempUser);
        return true;
    }
}
