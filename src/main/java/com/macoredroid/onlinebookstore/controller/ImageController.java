package com.macoredroid.onlinebookstore.controller;


import com.macoredroid.onlinebookstore.service.BooklistService;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@RestController
public class ImageController {
    @Autowired
    private BooklistService  BooklistService;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(value ="/image/{bookid}")
    public @ResponseBody byte[] getImage(@PathVariable("bookid") String bookid) throws IOException
    {
        return BooklistService.findCoverByID(bookid);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(value ="/setimage/{bookid}" ,method = RequestMethod.POST)
    public boolean  handleFileUpload(@PathVariable("bookid") String id,@RequestParam("file") MultipartFile file) throws IOException {
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if(!extension.equals("png"))
        {
            return false;
        }
        else
        {
            return BooklistService.setCover(id,file.getBytes());
        }

    }



}
