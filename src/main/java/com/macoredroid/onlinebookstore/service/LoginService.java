package com.macoredroid.onlinebookstore.service;

import com.macoredroid.onlinebookstore.entity.User;

public interface LoginService {
    User findbyUsername(String username);
}
