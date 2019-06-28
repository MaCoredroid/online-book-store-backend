package com.macoredroid.onlinebookstore.service;

import com.macoredroid.onlinebookstore.info.bookinfo;

import java.util.List;

public interface BooklistService {
    bookinfo findBookByID(Integer id);
    List<bookinfo> findAll();
    List<bookinfo> UserfindAll();
    byte[] findCoverByID(String id);
    boolean setCover(String id, byte[] cover);
    boolean block(String id);
    boolean unblock(String id);
    List<String> findAllbookid();
    List<String> userfindAllbookid();

}
