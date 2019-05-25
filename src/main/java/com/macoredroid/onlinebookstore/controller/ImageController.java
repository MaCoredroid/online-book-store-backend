package com.macoredroid.onlinebookstore.controller;


import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;


@RestController
public class ImageController {
    @GetMapping(value ="/image/{isbn}")
    public @ResponseBody byte[] getImage(@PathVariable("isbn") String isbn) throws IOException
    {
        isbn=isbn.replaceAll("[^\\x00-\\x7F]", "");
        String temp="image/"+isbn+".png";
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream in = classLoader.getResourceAsStream(temp);
        return IOUtils.toByteArray(in);
    }

}
