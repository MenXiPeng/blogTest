package com.mxp.blog.mapper;

import com.mxp.blog.model.Article;
import com.mxp.blog.model.Whisper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/24
 * TIME: 14:50
 */
@Mapper
public interface WhisperMapper {
    List<Whisper> selectAll();
}
