package com.macoredroid.onlinebookstore.service;

public interface LoginService {
    String Login(String username,String password);
    boolean findDuplicateUsername(String username);
}
