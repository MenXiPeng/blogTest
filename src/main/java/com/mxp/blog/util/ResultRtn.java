package com.mxp.blog.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User : Pengfei Zhang
 * Mail : Tubetrue01@gmail.com
 * Date : 2019-03-07
 * Time : 10:54
 */
@Getter
@Setter(AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultRtn<T> {
    private int code;
    private String msg;
    private PageInfo pageInfo;
    private List<T> dataList;

    @SafeVarargs
    public static <T> ResultRtn<T> of(int code, PageInfo pageInfo, T... t) {
        ResultRtn<T> resultRtn = of(code, t);
        resultRtn.setPageInfo(pageInfo);
        return resultRtn;
    }

    @SafeVarargs
    public static <T> ResultRtn<T> of(int code, T... t) {
        ResultRtn<T> result = new ResultRtn<>();
        result.setCode(code);
        result.setDataList(List.of(t));
        return result;
    }

    @SafeVarargs
    public static <T> ResultRtn<T> of(int code, String msg, T... t) {
        ResultRtn<T> result = new ResultRtn<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setDataList(List.of(t));
        return result;
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public static class PageInfo {

        private final int pageNum;
        private final int pageSize;
        private final long total;

        public static PageInfo of(int pageNum, int pageSize, long total) {
            return new PageInfo(pageNum, pageSize, total);
        }
    }
}
