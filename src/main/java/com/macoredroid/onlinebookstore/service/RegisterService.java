package com.macoredroid.onlinebookstore.service;

public interface RegisterService {
     boolean Register(String username, String password, String email, int star);
     boolean AdminRegister(String username,String password ,String email);
}
