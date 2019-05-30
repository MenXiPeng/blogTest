package com.mxp.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime time;
    private int like;
    private int leave;
    private String img;
}
