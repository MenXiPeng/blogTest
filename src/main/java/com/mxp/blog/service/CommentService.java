package com.mxp.blog.service;

import com.mxp.blog.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/31
 * TIME: 15:44
 */
public interface CommentService {
    Optional<List<Comment>> findCommentByArticleId(int id,int curr);
    int addComment(Comment comment);
}
