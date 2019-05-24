package com.mxp.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.mxp.blog.mapper.WhisperMapper;
import com.mxp.blog.model.Whisper;
import com.mxp.blog.service.WhisperService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/24
 * TIME: 14:58
 */
@Service
public class WhisperServiceImpl implements WhisperService {

    @Autowired
    private WhisperMapper whisperMapper;

    @Override
    public Optional<List<Whisper>> findAllByPage(int curr) {
        PageHelper.startPage(curr,10);
        return Optional.ofNullable(this.whisperMapper.selectAll());
    }
}
