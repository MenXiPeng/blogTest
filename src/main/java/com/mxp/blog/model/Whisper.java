package com.mxp.blog.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/24
 * TIME: 14:45
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Whisper extends Base{
    private int id;
    private String text;
    private LocalDateTime time;
    private int like;
    private int leave;
    private String img;
}
