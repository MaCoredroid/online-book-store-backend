package com.macoredroid.onlinebookstore.service;

import java.util.List;

public interface FriendService {
    List<String> getAllUsername();
    boolean beFriendWith(String username,String friend);
    List<String> getFriends(String username);
}
