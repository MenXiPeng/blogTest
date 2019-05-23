package com.mxp.blog.service;

import com.mxp.blog.model.Article;

import java.util.List;
import java.util.Optional;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/23
 * TIME: 15:23
 */
public interface ArticleService {
    Optional<List<Article>> selectAllByType(Article article);
}
