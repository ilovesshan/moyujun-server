package com.ilovesshan.user.handler;

import com.ilovesshan.common.excpetion.AccessDeniedException;
import com.ilovesshan.common.excpetion.AuthorizationException;
import com.ilovesshan.common.excpetion.CustomException;
import com.ilovesshan.common.model.R;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/2
 * @description:
 */

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 自定义异常
     */
    @ExceptionHandler(CustomException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R handleException(CustomException exception) {
        exception.printStackTrace();
        return R.fail(exception.getMessage(), null);
    }


    /**
     * 参数不匹配异常
     */
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public R handleMethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        exception.printStackTrace();
        return R.fail(exception.getAllErrors().get(0).getDefaultMessage());
    }

    /**
     * 暂无权限访问/操作该资源
     */
    @ExceptionHandler(value = {AccessDeniedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    @ResponseBody
    public R handleMethodArgumentNotValidExceptionHandler(AccessDeniedException exception) {
        exception.printStackTrace();
        return R.fail(R.ERROR_CODE_FORBIDDEN, R.ERROR_MESSAGE_FORBIDDEN);
    }


    /**
     * 权限异常
     */
    @ExceptionHandler(value = {AuthorizationException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public R handleMethodArgumentNotValidExceptionHandler(AuthorizationException exception) {
        exception.printStackTrace();
        return R.fail(R.ERROR_CODE_AUTHORIZATION, exception.getMessage());
    }


    /**
     * 其他异常
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R handleException(Exception exception) {
        exception.printStackTrace();
        return R.error(exception.getMessage(), null);
    }
}