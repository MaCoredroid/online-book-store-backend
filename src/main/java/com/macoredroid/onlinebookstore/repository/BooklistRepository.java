package com.macoredroid.onlinebookstore.repository;

import com.macoredroid.onlinebookstore.entity.Booklist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BooklistRepository extends JpaRepository<Booklist, Integer> {
    List<Booklist> findAll();
    Booklist findByIsbn(String isbn);
    Booklist findByName(String name);
}
