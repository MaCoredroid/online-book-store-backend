package com.macoredroid.onlinebookstore;

import com.macoredroid.onlinebookstore.service.BooklistService;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.List;

public class BooklistClient {


    public static void main(String[] args) throws NamingException, RemoteException {

        Context namingContext = new InitialContext();

        String url = "rmi://localhost/booklistService";
        BooklistService booklistService = (BooklistService) namingContext.lookup(url);



        System.out.println(booklistService.rmiFindBookDescription("American Dirt"));
    }

}
