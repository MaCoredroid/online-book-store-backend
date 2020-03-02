package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.AdminDao;
import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.Admin;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.info.Admininfo;
import com.macoredroid.onlinebookstore.info.Userinfo;
import com.macoredroid.onlinebookstore.service.GetUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserProfileServiceimpl implements GetUserProfileService {
    @Autowired
    private UserDao UserDao;
    @Autowired
    private AdminDao AdminDao;
    @Override
    public Userinfo GetUserProfile(String username) {
        User tempUser= UserDao.findOne(username);
        if(tempUser==null)
        {
            return null;
        }
        Userinfo res=new Userinfo(tempUser.getUserID(),tempUser.getEmail(),tempUser.getUsername(),true);
        return res;
    }

    @Override
    public Admininfo GetAdminProfile(String username) {
        Admin tempAdmin=AdminDao.findOne(username);
        if(tempAdmin==null)
        {
            return null;
        }
        Admininfo res=new Admininfo(tempAdmin.getAdminID(),tempAdmin.getEmail(),tempAdmin.getUsername());
        return res;
    }
}
