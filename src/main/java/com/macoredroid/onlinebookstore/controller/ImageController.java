package com.macoredroid.onlinebookstore.controller;


import com.macoredroid.onlinebookstore.service.BooklistService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
public class ImageController {

    @Autowired
    WebApplicationContext applicationContext;


    @GetMapping(value ="/image/{bookid}")
    public @ResponseBody byte[] getImage(@PathVariable("bookid") String bookid) throws IOException
    {
        BooklistService  booklistService=applicationContext.getBean(BooklistService.class);
        if(bookid.equals("undefined"))
        {
            return null;
        }
        return booklistService.findCoverByID(bookid);
    }


    @RequestMapping(value ="/setimage/{bookid}" ,method = RequestMethod.POST)
    public boolean  handleFileUpload(@PathVariable("bookid") String id,@RequestParam("file") MultipartFile file) throws IOException {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        BooklistService  booklistService=applicationContext.getBean(BooklistService.class);
        if(!extension.equals("png")&&!extension.equals("jpg"))
        {
            return false;
        }
        else
        {
            return booklistService.setCover(id,file.getBytes());
        }

    }



}
