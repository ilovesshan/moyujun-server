package com.ilovesshan.common.model;

import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/7/30
 * @description:
 */
@Data
public class A1<T> {
    private Integer code;
    private String message;
    private T data;



    public static <T> A1<T> success1( T t) {
        A1<T> a1 = new A1<>();
        a1.setCode(200);
        a1.setMessage("200");
        a1.setData(t);
        return  a1;
    }

    public static <T> A1<T> success(T t) {
        A1<T> a1 = new A1<>();
        a1.setCode(200);
        a1.setMessage("200");
        a1.setData(t);
        return a1;
    }
}
