package com.ilovesshan.user.util;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/5
 * @description:
 */

@Component
public class MailSenderUtil {

    @Resource
    private JavaMailSender javaMailSender;

    public void send(String toEmail, String verifyCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        // 发件人
        message.setFrom("2665939276@qq.com");
        // 收件人(可实现批量发送)
        message.setTo(toEmail);
        // 邮箱标题
        message.setSubject("【摸鱼君门户网站】");
        // 邮箱内容
        message.setText("亲爱的" + toEmail + "恭喜您即将成为摸鱼君门户网站的一员，您本次的验证码为 " + verifyCode + "【3分钟内有效】, 请勿将此验证码转发或者提供给其他人~");
        // 发送
        javaMailSender.send(message);
    }
}
