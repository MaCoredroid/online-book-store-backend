package com.macoredroid.onlinebookstore.repository;

import com.macoredroid.onlinebookstore.entity.Cover;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CoverRepository extends MongoRepository<Cover,String>{
     Cover findByBookid(String bookid);
}
