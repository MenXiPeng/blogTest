package com.mxp.blog.service;

import com.mxp.blog.model.Whisper;

import java.util.List;
import java.util.Optional;

/**
 * EMAIL menxipeng@gmail.com
 * AUTHOR:menxipeng
 * DATE: 2019/5/24
 * TIME: 14:56
 */
public interface WhisperService {
    Optional<List<Whisper>> findAllByPage(int curr);
}
