package com.mxp.blog.mapper;

import com.mxp.blog.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/6/3
 * TIME: 13:57
 */
@Mapper
public interface UserMapper {
    User selectByPassword(User user);
}
