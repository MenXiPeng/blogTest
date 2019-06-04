package com.mxp.blog.controller;

import com.mxp.blog.model.User;
import com.mxp.blog.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/6/4
 * TIME: 15:37
 */
@Log4j2
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login(HttpServletRequest request) {
        System.out.println("进来了");
        return "login";
    }

    @ResponseBody
    @PostMapping("/login")
    public DeferredResult<Map> login(@RequestBody User user, HttpSession session) {
        var map = new HashMap<String, Object>();
        var resulet = new DeferredResult<Map>();
        CompletableFuture.supplyAsync(() -> this.userService.findByPassword(user).
                        map(user1 -> {
                            session.setMaxInactiveInterval(36000);
                            session.setAttribute(user.getUsername(), user);
                            map.put("status", 0);
                            map.put("data", user);
                            resulet.setResult(map);
                            return "Success";
                        }).orElseGet(() -> {
                            log.warn("用户不存在");
                            map.put("status", 1);
                            map.put("data", user);
                            resulet.setResult(map);
                            return "Error";
                        })
        ).orTimeout(20000, TimeUnit.MILLISECONDS).exceptionally(e -> {
            log.error("用户登录数据异常", e);
            return null;
        });
        return resulet;
    }
}
