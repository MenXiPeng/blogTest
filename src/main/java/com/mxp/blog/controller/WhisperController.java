package com.mxp.blog.controller;

import com.github.pagehelper.PageInfo;
import com.mxp.blog.model.Whisper;
import com.mxp.blog.service.WhisperService;
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
 * DATE: 2019/5/24
 * TIME: 11:24
 */
@Log4j2
@Controller
public class WhisperController {

    @Autowired
    private WhisperService whisperService;

    @GetMapping("/whisper")
    public String whisper(HttpServletRequest request) {
        System.out.println("进来了");
        return "whisper";
    }

    @ResponseBody
    @PostMapping("/whisperData")
    public DeferredResult<PageInfo> whisperData(@RequestBody Whisper whisper) {
        var result = new DeferredResult<PageInfo>();
        CompletableFuture.supplyAsync(() -> this.whisperService.findAllByPage(whisper.getCurr())
                .map(whispers -> {
                    //将数据加入到pageInfo中,连续显示的页数
                    PageInfo pageInfo = new PageInfo(whispers, 5);
                    result.setResult(pageInfo);
                    return "Success";
                }).orElseGet(() -> {
                    log.warn("查询数据为空");
                    return "Error";
                })
        ).orTimeout(20000, TimeUnit.MILLISECONDS).exceptionally(e -> {
           log.error("查询微语数据异常",e);
            return null;
        });
        return result;
    }
}
