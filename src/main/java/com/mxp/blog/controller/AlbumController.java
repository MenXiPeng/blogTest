package com.mxp.blog.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/24
 * TIME: 17:06
 */
@Log4j2
@Controller
public class AlbumController {
    @GetMapping("/album")
    public String album(HttpServletRequest request) {
        System.out.println("进来了");
        return "album";
    }
}
