package com.ilovesshan.common.model;

import lombok.*;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/7/30
 * @description:
 */

@Data
public class R<T> implements Serializable {

    private static final long serialVersionUID = 1946123740512009003L;

    public static final int SUCCESS_CODE = 200;
    public static final int ERROR_CODE_CLIENT = -200;
    public static final int ERROR_CODE_AUTHORIZATION = 401;
    public static final int ERROR_CODE_FORBIDDEN = 403;
    public static final int ERROR_CODE_INTERNAL_SERVER = 500;


    public static final String SUCCESS_MESSAGE = "操作成功";
    public static final String ERROR_MESSAGE = "操作失败";

    public static final String SUCCESS_VERIFY_MESSAGE = "校验成功";
    public static final String ERROR_VERIFY_MESSAGE = "校验失败";

    public static final String SUCCESS_MESSAGE_SELECT = "查询成功";
    public static final String SUCCESS_MESSAGE_INSERT = "新增成功";
    public static final String SUCCESS_MESSAGE_DELETE = "删除成功";
    public static final String SUCCESS_MESSAGE_UPDATE = "更新成功";

    public static final String ERROR_MESSAGE_SELECT = "查询失败";
    public static final String ERROR_MESSAGE_INSERT = "新增失败";
    public static final String ERROR_MESSAGE_DELETE = "删除失败";
    public static final String ERROR_MESSAGE_UPDATE = "更新失败";

    public static final String SUCCESS_MESSAGE_LOGIN = "登录成功";
    public static final String ERROR_MESSAGE_LOGIN = "登录失败";

    public static final String SUCCESS_MESSAGE_REGISTER = "注册成功";
    public static final String ERROR_MESSAGE_REGISTER = "注册失败";

    public static final String SUCCESS_MESSAGE_LOGOUT = "退出登录成功";
    public static final String ERROR_MESSAGE_LOGOUT = "退出登录失败";

    public static final String ERROR_MESSAGE_FORBIDDEN = "暂无权限访问/操作该资源";
    public static final String ERROR_INSUFFICIENT_AUTHENTICATION = "身份认证失败，无效的令牌";
    public static final String ERROR_WX_VALID_CODE = "无效的code,请到微信开发平台校验";

    public static final String ERROR_USER_DISABLED = "账户不可用";
    public static final String ERROR_USER_LOCKED = "账户锁定";
    public static final String ERROR_USER_NAME_OR_PASSWORD = "用户名或者密码错误";
    public static final String ERROR_OLD_PASSWORD = "旧密码错误";
    public static final String ERROR_USER_NOT_FOUND = "用户不存在";
    public static final String ERROR_USER_ALREADY_EXIST = "用户已经存在";


    public static final String ERROR_RESOURCES_NOTFOUND = "资源不存在";
    public static final String ERROR_RESOURCES_EXISTS = "资源已存在";
    public static final String SUCCESS_ATTACHMENT_UPLOAD = "附件上传成功";
    public static final String ERROR_ATTACHMENT_UPLOAD = "附件上传失败";
    public static final String ERROR_ATTACHMENT_NOTFOUND = "附件不存在";


    private Integer code;
    private String message;
    private T data;


    public static <T> R<T> success() {
        val r = new R<T>();
        r.setCode(SUCCESS_CODE);
        r.setMessage(SUCCESS_MESSAGE);
        return r;
    }

    public static <T> R<T> success(String message) {
        val r = new R<T>();
        r.setCode(SUCCESS_CODE);
        r.setMessage(message);
        return r;
    }

    public static <T> R<T> success(T data) {
        val r = new R<T>();
        r.setCode(SUCCESS_CODE);
        r.setMessage(SUCCESS_MESSAGE);
        r.setData(data);
        return r;
    }

    public static <T> R<T> success(String message, T data) {
        val r = new R<T>();
        r.setCode(SUCCESS_CODE);
        r.setMessage(message);
        r.setData(data);
        return r;
    }


    public static <T> R<T> fail() {
        val r = new R<T>();
        r.setCode(ERROR_CODE_CLIENT);
        r.setMessage(ERROR_MESSAGE);
        return r;
    }

    public static <T> R<T> fail(String message) {
        val r = new R<T>();
        r.setCode(ERROR_CODE_CLIENT);
        r.setMessage(message);
        return r;
    }

    public static <T> R<T> fail(T data) {
        val r = new R<T>();
        r.setCode(ERROR_CODE_CLIENT);
        r.setMessage(ERROR_MESSAGE);
        r.setData(data);
        return r;
    }

    public static <T> R<T> fail(String message, T data) {
        val r = new R<T>();
        r.setCode(ERROR_CODE_CLIENT);
        r.setMessage(message);
        r.setData(data);
        return r;
    }


    public static <T> R<T> error() {
        val r = new R<T>();
        r.setCode(ERROR_CODE_INTERNAL_SERVER);
        r.setMessage(ERROR_MESSAGE);
        return r;
    }

    public static <T> R<T> error(String message) {
        val r = new R<T>();
        r.setCode(ERROR_CODE_INTERNAL_SERVER);
        r.setMessage(message);
        return r;
    }

    public static <T> R<T> error(T data) {
        val r = new R<T>();
        r.setCode(ERROR_CODE_INTERNAL_SERVER);
        r.setMessage(ERROR_MESSAGE);
        r.setData(data);
        return r;
    }

    public static <T> R<T> error(String message, T data) {
        val r = new R<T>();
        r.setCode(ERROR_CODE_INTERNAL_SERVER);
        r.setMessage(message);
        r.setData(data);
        return r;
    }

}