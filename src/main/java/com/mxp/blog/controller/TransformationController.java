package com.mxp.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/21
 * TIME: 9:56
 */
@Controller
public class TransformationController {

    @GetMapping("/index")
    public String demo(HttpServletRequest request){
        request.setAttribute("url","1.html");
        System.out.println("进来了");
        return "index";
    }
    @GetMapping("/index1")
    public String demo1(HttpServletRequest request){
        System.out.println("进来了");
        request.setAttribute("url","1.html");
        return "index";
    }

    @ResponseBody
    @GetMapping("/index2")
    public Map demo2(HttpServletRequest request){
        String s = request.getParameter("curr");
        System.out.println("--->"+s);
        List list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        String mb = "";
        var map = new HashMap<String,List>();
        System.out.println("进来了");
        map.put("list",list);
        return map;
    }
}
