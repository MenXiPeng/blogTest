package com.mxp.blog.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mxp.blog.mapper.ArticleMapper;
import com.mxp.blog.model.Article;
import com.mxp.blog.service.ArticleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/21
 * TIME: 9:56
 */
@Log4j2
@Controller
public class TransformationController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private ArticleMapper articleMapper;

    @GetMapping("/index")
    public String demo(HttpServletRequest request) {
        request.setAttribute("url", "1.html");
        System.out.println("进来了");
        return "index";
    }


    @ResponseBody
    @PostMapping("/breadcrumbData")
    public DeferredResult<PageInfo> breadcrumbData(@RequestBody Article article) {
        var result = new DeferredResult<PageInfo>();
        //使用分页先调用PageHelper方法
        System.out.println(article.getCurr());
        CompletableFuture.supplyAsync(() -> this.articleService.selectAllByType(article)
                .map(articles -> {
                    //将数据加入到pageInfo中,连续显示的页数
                    PageInfo pageInfo = new PageInfo(articles,5);
                    result.setResult(pageInfo);
                    return "Success";
                }).orElseGet(() -> {
                    log.warn("查询数据为空");
                    return "Error";
                })
        ).orTimeout(20000, TimeUnit.MILLISECONDS).exceptionally(e -> {
            log.error("查询标签页异常：{}",e);
            return null;
        });;
        return result;
    }

}
