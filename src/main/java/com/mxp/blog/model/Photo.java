package com.mxp.blog.model;

import lombok.Data;

import java.util.List;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/30
 * TIME: 17:15
 */
@Data
public class Photo{
    private int acticleId;
    private List<String> image;
}