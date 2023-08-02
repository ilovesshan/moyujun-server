package com.ilovesshan.common.excpetion;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/2
 * @description:
 */

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
