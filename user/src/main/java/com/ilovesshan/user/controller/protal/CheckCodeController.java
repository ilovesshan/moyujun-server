package com.ilovesshan.user.controller.protal;

import com.ilovesshan.common.model.R;
import com.ilovesshan.user.util.RedisCache;
import com.ilovesshan.user.model.po.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/7/30
 * @description:
 */
@RestController
@RequestMapping("/check")
@Api(tags = "验证码/手机号/邮箱模块")
@Slf4j
public class CheckCodeController {

    @Resource
    private RedisCache redisCache;

    @GetMapping("/captcha")
    @ApiOperation(value = "获取图灵验证码")
    public R getCaptchaCheckCode() {
        return R.success();
    }

    @GetMapping("/phone")
    @ApiImplicitParams(
            @ApiImplicitParam(name = "phone", value = "手机号", required = true, paramType = "query")
    )
    @ApiOperation(value = "获取手机验证码")
    public R<UserInfo> getPhoneCheckCode() {
        val userInfo = new UserInfo();
        redisCache.set("userinfo", userInfo, 20);
        log.debug("set ok~");
        val t = redisCache.get("userinfo", UserInfo.class);
        log.debug("get ok~");
        return R.success(t);
    }

    @GetMapping("/email")
    @ApiOperation(value = "获取邮箱验证码")
    public R getEmailCheckCode() {
        return R.success();
    }

    @PostMapping("/phone")
    @ApiOperation(value = "校验手机号")
    public R checkPhone() {
        return R.success();
    }

    @PostMapping("/email")
    @ApiOperation(value = "校验邮箱")
    public R checkEmail() {
        return R.success();
    }

}
