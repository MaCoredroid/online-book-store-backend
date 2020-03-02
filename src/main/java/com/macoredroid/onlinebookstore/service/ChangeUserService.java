package com.macoredroid.onlinebookstore.service;

public interface ChangeUserService {
    boolean ChangeUsername(String username, String newusername);
    boolean ChangeAdminUsername(String username, String newusername);
    boolean ChangeAdminPassword(String username,String newpassword);
    boolean ChangeEmail(String username, String newemail);
    boolean ChangePassword(String username, String newpassword);
}
