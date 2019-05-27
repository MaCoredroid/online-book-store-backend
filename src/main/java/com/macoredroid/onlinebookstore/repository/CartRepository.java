package com.macoredroid.onlinebookstore.repository;

import com.macoredroid.onlinebookstore.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}
