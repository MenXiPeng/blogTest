package com.mxp.blog.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/23
 * TIME: 13:42
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Article extends Base {
    private int id;
    private String type;
    private String title;
    private String subtitle;
    private String introduction;
    private String text;
    private String img;
    private Photo photo;
    private LocalDateTime createTime;

}
