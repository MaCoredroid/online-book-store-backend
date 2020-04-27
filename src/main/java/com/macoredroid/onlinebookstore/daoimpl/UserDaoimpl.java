package com.macoredroid.onlinebookstore.daoimpl;

import com.macoredroid.onlinebookstore.dao.UserDao;
import com.macoredroid.onlinebookstore.entity.Friend;
import com.macoredroid.onlinebookstore.entity.User;
import com.macoredroid.onlinebookstore.repository.FriendRepository;
import com.macoredroid.onlinebookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class UserDaoimpl implements UserDao {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FriendRepository friendRepository;

    @Override
    public User findOne(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(int id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void save(String username, String password, String email, int star) {
        User temp= new User(username,password,email,star);
        userRepository.save(temp);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void remove(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public boolean beFriendWith(String username,String friend) {
        Friend user;
        Friend another;
        if(friendRepository.findByName(username)==null)
        {
            user = new Friend(username);
        }
        else
        {
            user=friendRepository.findByName(username);
        }
        if(friendRepository.findByName(friend)==null)
        {
            another = new Friend(friend);
        }
        else
        {
            another=friendRepository.findByName(friend);
        }

        friendRepository.save(user);
        friendRepository.save(another);
        user=friendRepository.findByName(username);
        user.beFriendWith(another);
        friendRepository.save(user);
        return true;


    }

    @Override
    public List<String> getFriends(String username) {
        Friend friend=friendRepository.findByName(username);
        if(friend==null)
        {
            return new ArrayList<>();
        }
        return Optional.ofNullable(friend.friends).orElse(
                Collections.emptySet()).stream()
                .map(Friend::getName)
                .collect(Collectors.toList());
    }
}
