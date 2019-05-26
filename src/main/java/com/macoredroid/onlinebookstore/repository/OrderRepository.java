package com.macoredroid.onlinebookstore.repository;


import com.macoredroid.onlinebookstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAIIByUsername(String username);
    List<Order> findAllByIsbn(String isbn);

}
