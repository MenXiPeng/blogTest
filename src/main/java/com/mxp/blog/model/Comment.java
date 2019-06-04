package com.mxp.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/31
 * TIME: 14:33
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Comment extends Base{
   private Integer id;
   private String text;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
   private LocalDateTime createTime;
   private String ip;
   private Integer userId;
   private Integer articleId;
   private User user;
}
