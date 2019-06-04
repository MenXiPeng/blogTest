package com.mxp.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.mxp.blog.mapper.CommentMapper;
import com.mxp.blog.model.Comment;
import com.mxp.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/6/3
 * TIME: 13:39
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;


    @Override
    public Optional<List<Comment>> findCommentByArticleId(int id,int curr) {
        PageHelper.startPage(curr,10);
        return Optional.ofNullable(this.commentMapper.selectAllByArticleId(id));
    }

    @Override
    public int addComment(Comment comment) {
        return commentMapper.insertComment(comment);
    }
}
