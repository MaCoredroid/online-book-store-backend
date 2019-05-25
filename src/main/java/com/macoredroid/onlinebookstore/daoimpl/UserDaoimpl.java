package com.macoredroid.onlinebookstore.daoimpl;

import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoimpl implements UserDao {

    @Autowired
    private UserRepository userRepository;



    @Override
    public User findOne(Integer id) {
        return userRepository.getOne(id);
    }

    @Override
    public User findOne(String username) {
        return userRepository.findByUsername(username);
    }
}
