package com.macoredroid.onlinebookstore.dao;

import com.macoredroid.onlinebookstore.entity.User;



public interface UserDao {
    User findOne(Integer id);
    User findOne(String username);
}
