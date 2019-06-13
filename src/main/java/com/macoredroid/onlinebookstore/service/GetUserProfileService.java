package com.macoredroid.onlinebookstore.service;

import com.macoredroid.onlinebookstore.info.Userinfo;

public interface GetUserProfileService {
    Userinfo GetUserProfile(String username);
}
