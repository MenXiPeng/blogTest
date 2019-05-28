package com.mxp.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.mxp.blog.mapper.ArticleMapper;
import com.mxp.blog.model.Article;
import com.mxp.blog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/23
 * TIME: 15:27
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public Optional<List<Article>> selectAllByType(Article article) {
        PageHelper.startPage(article.getCurr(),10);
        return Optional.ofNullable(this.articleMapper.selectAllByType(article));
    }

    @Override
    public int addArticle(Article article) {
        return this.articleMapper.insertArticle(article);
    }
}
