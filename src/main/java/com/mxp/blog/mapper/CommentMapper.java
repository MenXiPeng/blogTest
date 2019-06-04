package com.mxp.blog.mapper;

import com.mxp.blog.model.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/31
 * TIME: 14:43
 */
@Mapper
public interface CommentMapper {
    List<Comment> selectAllByArticleId(int articleId);

    int insertComment(Comment comment);
}
