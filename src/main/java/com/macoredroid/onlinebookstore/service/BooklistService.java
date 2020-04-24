package com.macoredroid.onlinebookstore.service;

import com.macoredroid.onlinebookstore.info.bookinfo;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface BooklistService extends Remote {
    bookinfo findBookByID(Integer id) throws RemoteException;
    String rmiFindBookDescription(String name) throws RemoteException;
    List<bookinfo> findAll() throws RemoteException;
    List<bookinfo> UserfindAll() throws RemoteException;
    byte[] findCoverByID(String id) throws RemoteException;
    String getDescriptionByBookId(String BookId) throws RemoteException;
    String searchInDescription(String word) throws Exception;
    boolean setCover(String id, byte[] cover) throws RemoteException;
    boolean block(String id) throws RemoteException;
    boolean unblock(String id) throws RemoteException;
    List<String> findAllbookid() throws RemoteException;
    List<String> userfindAllbookid() throws RemoteException;
    String NewBook(String name, String author,int price,String isbn, int stock) throws RemoteException;
    boolean DeleteBook(String id) throws RemoteException;

}
