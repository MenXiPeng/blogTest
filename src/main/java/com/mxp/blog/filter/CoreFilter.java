package com.mxp.blog.filter;

import com.google.gson.Gson;
import com.mxp.blog.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2019-03-07
 * Time : 11:17
 */
@Log4j2
@Order(1)
@WebFilter(urlPatterns = "/*", asyncSupported = true)
public class CoreFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) {
        Map map = new HashMap<String, Object>();
        // 过滤器
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String url = request.getRequestURL().toString();
        HttpSession session = request.getSession();
        if (url.contains("write")) {
            Optional.ofNullable((User) session.getAttribute("user"))
                    .map(user -> {
                        try {
                            chain.doFilter(request, response);
                        } catch (IOException | ServletException e) {
                            e.printStackTrace();
                        }
                        return "Success!";
                    })
                    .orElseGet(() -> {
                        try {
                            map.put("status", 10034);
                            map.put("message", "登录超时");
                            Gson gson = new Gson();
                            String result = gson.toJson(map);
                            log.info("-==登录超时！==-");
                            response.getWriter().print(result);
                        } catch (IOException e) {
                            log.warn("-==响应失败！=-", e);
                        }
                        return "Error!";
                    });
        } else {
            try {
                chain.doFilter(request, response);
            } catch (IOException | ServletException e) {
                e.printStackTrace();
            }
        }

    }
}