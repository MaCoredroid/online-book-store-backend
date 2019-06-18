package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.info.Userinfo;
import com.macoredroid.onlinebookstore.service.GetUserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserProfileServiceimpl implements GetUserProfileService {
    @Autowired
    private UserDao UserDao;
    @Override
    public Userinfo GetUserProfile(String username) {
        User tempUser= UserDao.findOne(username);
        if(tempUser==null)
        {
            return null;
        }
        Userinfo res=new Userinfo(tempUser.getUserID(),tempUser.getEmail(),tempUser.getUsername());
        return res;
    }
}
