package com.macoredroid.onlinebookstore.dao;

import com.macoredroid.onlinebookstore.entity.Admin;

import java.util.List;

public interface AdminDao {
    Admin findOne(String username);
    void save(String username,String password,String email);
    void save(Admin Admin);
    List<Admin> findAll();
    void remove(Integer id);
}
