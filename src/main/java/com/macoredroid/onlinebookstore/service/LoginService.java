package com.macoredroid.onlinebookstore.service;

public interface LoginService {
    Boolean LoginWithoutVerify();
    String Login(String username,String password);
    boolean findDuplicateUsername(String username);
}
