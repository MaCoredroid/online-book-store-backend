package com.macoredroid.onlinebookstore;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class CustomerizedLogger {
    private AtomicInteger c = new AtomicInteger(0);
    public void writeLog(String content) throws IOException {
        if(c.get()>=1000)
        {
            c.getAndSet(0);
            callHBase();

        }
        FileWriter writer = new FileWriter("log.txt", true);
        BufferedWriter bw = new BufferedWriter(writer);
        bw.write(content);
        bw.write(System.getProperty( "line.separator" ));
        bw.close();



        c.incrementAndGet();
    }
    @Async
    void callHBase()
    {
        HBase.addFile();
    }
}
