package com.macoredroid.onlinebookstore.dao;

import com.macoredroid.onlinebookstore.entity.User;



public interface UserDao {
    User findOne(String username);
    void save(String username,String password,String email,int star);
}
