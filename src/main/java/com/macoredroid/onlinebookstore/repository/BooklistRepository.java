package com.macoredroid.onlinebookstore.repository;

import com.macoredroid.onlinebookstore.entity.Booklist;
import org.springframework.data.jpa.repository.JpaRepository;
public interface BooklistRepository extends JpaRepository<Booklist, Integer> {

}
