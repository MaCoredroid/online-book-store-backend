package com.macoredroid.onlinebookstore.controller;


import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;


@RestController
public class ImageController {
    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value ="/image/{bookid}")
    public @ResponseBody byte[] getImage(@PathVariable("bookid") String bookid) throws IOException
    {

        String temp="image/"+bookid+".png";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream in = classLoader.getResourceAsStream(temp);
        if( in!=null)
        {
            return IOUtils.toByteArray(in);
        }
        else
        {
            return null;
        }
    }

}
