package com.macoredroid.onlinebookstore;
import com.macoredroid.onlinebookstore.serviceimpl.BooklistServiceimpl;
import com.macoredroid.onlinebookstore.service.BooklistService;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.rmi.RemoteException;
public class BooklistServer {
    public static void main(String[] args) throws
            RemoteException, NamingException {
        System.out.println("Constructing server implementation...");
        BooklistServiceimpl booklistServiceimpl = new BooklistServiceimpl();

        System.out.println("Binding server implementation to registry...");
        Context namingContext = new InitialContext();
        namingContext.bind("rmi:booklistService", booklistServiceimpl);

        System.out.println("Waiting for invocations from clients...");
    }

}
