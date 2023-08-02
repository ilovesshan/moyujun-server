package com.ilovesshan.user.service;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/2
 * @description:
 */
public interface CheckCodeService {

    /**
     * 获取邮箱验证码
     *
     * @param email 邮箱地址
     * @return 是否发送成功
     */
    boolean getEmailVerifyCode(String email);

    /**
     * 校验邮箱验证码
     *
     * @param email 邮箱地址
     * @param code  验证码
     * @return 是否校验成功
     */
    boolean checkEmailVerifyCode(String email, String code);
}
