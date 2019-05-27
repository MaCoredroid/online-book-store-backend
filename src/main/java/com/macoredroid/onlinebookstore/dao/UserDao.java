package com.macoredroid.onlinebookstore.dao;

import com.macoredroid.onlinebookstore.entity.User;



public interface UserDao {
    User findOne(String username);
}
