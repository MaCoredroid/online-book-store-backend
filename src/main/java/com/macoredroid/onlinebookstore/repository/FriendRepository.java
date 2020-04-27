package com.macoredroid.onlinebookstore.repository;

import com.macoredroid.onlinebookstore.entity.Friend;
import org.springframework.data.repository.CrudRepository;

public interface FriendRepository extends CrudRepository<Friend, Long> {

    Friend findByName(String name);
}