package com.mxp.blog.mapper;

import com.mxp.blog.model.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/23
 * TIME: 14:23
 */
@Mapper
public interface ArticleMapper {
    List<Article> selectAllByType(Article article);
}
