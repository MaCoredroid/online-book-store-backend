package com.macoredroid.onlinebookstore.repository;


import com.macoredroid.onlinebookstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findAllByIsbn(String isbn);
    List<Order> findAllByUserid(int userid);

}
