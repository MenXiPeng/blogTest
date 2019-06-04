package com.mxp.blog.service.impl;

import com.mxp.blog.mapper.UserMapper;
import com.mxp.blog.model.User;
import com.mxp.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/6/4
 * TIME: 17:27
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Optional<User> findByPassword(User user) {
        return Optional.ofNullable(userMapper.selectByPassword(user));
    }
}
