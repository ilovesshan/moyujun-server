package com.ilovesshan.user.service.impl;

import com.ilovesshan.common.excpetion.CustomException;
import com.ilovesshan.common.util.RandomUtil;
import com.ilovesshan.user.service.CheckCodeService;
import com.ilovesshan.user.util.RedisCache;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
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
    private JavaMailSender javaMailSender;

    @Resource
    private RedisCache redisCache;


    @Override
    public boolean getEmailVerifyCode(String email) {
        val verifyCode = RandomUtil.getRandomStr(6);

        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人
        message.setFrom("2665939276@qq.com");
        // 收件人(可实现批量发送)
        message.setTo(email);
        // 邮箱标题
        message.setSubject("【摸鱼君门户网站】");
        // 邮箱内容
        message.setText("亲爱的" + email + "恭喜您即将成为摸鱼君门户网站的一员，您本次的验证码为 " + verifyCode + "【3分钟内有效】, 请勿将此验证码转发或者提供给其他人~");
        // 发送邮件
        try {
            javaMailSender.send(message);
            // 将验证码和邮箱地址存入Redis 有效期1分钟
            redisCache.set(email, email + "_%_" + verifyCode, 60 * 3);
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
