package com.ilovesshan.user.service.impl;

import com.ilovesshan.common.excpetion.CustomException;
import com.ilovesshan.common.util.RandomUtil;
import com.ilovesshan.user.constants.Constants;
import com.ilovesshan.user.service.CheckCodeService;
import com.ilovesshan.user.util.MailSenderUtil;
import com.ilovesshan.user.util.RedisCache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/2
 * @description:
 */

@Service
@Slf4j
public class CheckCodeServiceImpl implements CheckCodeService {

    @Resource
    private MailSenderUtil mailSenderUtil;

    @Resource
    private RedisCache redisCache;


    @Override
    public boolean getEmailVerifyCode(String email) {
        // 做一个限流 一分钟只能发一次
        int limits = 0;
        try {
            limits = redisCache.get(Constants.UserKey.REDIS_CODE_LIMIT_PREFIX + email, int.class);
        } catch (Exception ignored) {
        }
        if (limits >= 2) {
            throw new CustomException("验证码调用频繁，请稍再试");
        } else {
            limits++;
            redisCache.set(Constants.UserKey.REDIS_CODE_LIMIT_PREFIX + email, limits, Constants.TimeKey.ONE_MINUTES);
        }
        // 生成验证码
        String verifyCode = RandomUtil.getRandomStr(6);
        // 发送邮件
        try {
            mailSenderUtil.send(email, verifyCode);
            // 将验证码和邮箱地址存入Redis 有效期3分钟
            redisCache.set(Constants.UserKey.REDIS_CODE_PREFIX + email, email + "_%_" + verifyCode, Constants.TimeKey.ONE_MINUTES * 3);
        } catch (Exception exception) {
            log.error("电子邮箱验证失败: {}", exception.getMessage(), exception);
            throw new CustomException("电子邮箱服务繁忙，请稍后再试");
        }
        return true;
    }

    @Override
    public boolean checkEmailVerifyCode(String email, String code) {
        String verifyCode = redisCache.get(email, String.class);
        if (verifyCode != null) {
            String[] kv = verifyCode.split("_%_");
            if (email.equals(kv[0]) && code.equals(kv[1])) {
                redisCache.remove(email);
                return true;
            }
        }
        return false;
    }
}
