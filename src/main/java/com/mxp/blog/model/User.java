package com.mxp.blog.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/31
 * TIME: 15:06
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends Base{
    private int id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private String email;
    private String address;
    private String head;
}
