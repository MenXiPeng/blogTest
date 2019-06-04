package com.mxp.blog.service;

import com.mxp.blog.model.User;

import java.util.Optional;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/6/4
 * TIME: 17:27
 */
public interface UserService {
    Optional<User> findByPassword(User user);
}
