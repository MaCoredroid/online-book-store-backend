package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.info.Userinfo;
import com.macoredroid.onlinebookstore.service.SeeAllUsers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class SeeAllUsersimpl implements SeeAllUsers {
    @Autowired
    private UserDao UserDao;
    @Override
    public List<Userinfo> SeeAllUsers() {
        List<User> tempUserlist=UserDao.findAll();
        List<Userinfo> reslist=new ArrayList<>();
        for(User tempUser:tempUserlist)
        {
            if(tempUser.getStar()==2)
            {
                Userinfo tempinfo= new Userinfo(tempUser.getUserID(),tempUser.getEmail(),tempUser.getUsername(),true);
                reslist.add(tempinfo);
            }
            else
            {
                Userinfo tempinfo= new Userinfo(tempUser.getUserID(),tempUser.getEmail(),tempUser.getUsername(),false);
                reslist.add(tempinfo);
            }
        }
        return reslist;
    }
}
