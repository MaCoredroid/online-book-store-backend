package com.macoredroid.onlinebookstore.service;

public interface ChangeUserService {
    boolean ChangeUsername(String username, String newusername);
    boolean ChangeEmail(String username, String newemail);
}
