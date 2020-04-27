package com.macoredroid.onlinebookstore.serviceimpl;

import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.info.Userinfo;
import com.macoredroid.onlinebookstore.repository.FriendRepository;
import com.macoredroid.onlinebookstore.service.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FriendServiceimpl implements FriendService {
    @Autowired
    private UserDao userDao;
    @Override
    public List<String> getAllUsername() {
        List<User> tempUserlist=userDao.findAll();
        List<String> reslist=new ArrayList<>();
        for(User tempUser:tempUserlist)
        {
            reslist.add(tempUser.getUsername());
        }
        return reslist;
    }

    @Override
    public boolean beFriendWith(String username, String friend) {
        return userDao.beFriendWith(username,friend);
    }

    @Override
    public List<String> getFriends(String username) {
        return userDao.getFriends(username);
    }
}
