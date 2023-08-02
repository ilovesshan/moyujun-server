package com.ilovesshan.user.controller.protal;

import com.ilovesshan.common.model.R;
import com.ilovesshan.user.service.CheckCodeService;
import com.ramostear.captcha.HappyCaptcha;
import com.ramostear.captcha.support.CaptchaStyle;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/7/30
 * @description:
 */
@RestController
@Api(tags = "图灵验证码/手机号/邮箱模块")
@Slf4j
public class CheckCodeController {

    @Resource
    private CheckCodeService checkCodeService;

    @GetMapping("/captcha")
    @ApiOperation(value = "获取图灵验证码")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "length", defaultValue = "5", value = "验证码字符长度", dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "width", defaultValue = "220", value = "验证码图片长度", dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "height", defaultValue = "80", value = "验证码图片高度", dataType = "int", paramType = "query"),
                    @ApiImplicitParam(name = "isImage", defaultValue = "true", value = "验证码展现形式,是图片还是动画，默认图片", dataType = "bool", paramType = "query"),
            }
    )
    public void getCaptchaCheckCode(
            @RequestParam(defaultValue = "5") Integer length,
            @RequestParam(defaultValue = "220") Integer width,
            @RequestParam(defaultValue = "80") Integer height,
            @RequestParam(defaultValue = "true") Boolean isImage,
            HttpServletRequest request,
            HttpServletResponse response
    ) {
        HappyCaptcha.
                require(request, response)
                .length(length)
                .width(width)
                .height(height)
                .style(isImage ? CaptchaStyle.IMG : CaptchaStyle.ANIM)
                .build().finish();
    }

    @PostMapping("/captcha")
    @ApiOperation(value = "校验图灵验证码")
    @ApiImplicitParams(@ApiImplicitParam(name = "code", value = "验证码", required = true, paramType = "body"))
    public R verify(@RequestBody String code, HttpServletRequest request) {
        boolean checkResult = HappyCaptcha.verification(request, code, true);
        // 不管有没有成功都需要将当前验证码清理掉
        HappyCaptcha.remove(request);
        return checkResult ? R.success(R.SUCCESS_VERIFY_MESSAGE) : R.fail(R.ERROR_VERIFY_MESSAGE);
    }

    @GetMapping("/phone")
    @ApiImplicitParams(@ApiImplicitParam(name = "phone", value = "手机号", required = true, paramType = "body"))
    @ApiOperation(value = "获取手机验证码")
    public R getPhoneCheckCode() {
        return R.success();
    }

    @PostMapping("/phone")
    @ApiOperation(value = "校验手机号")
    public R checkPhone() {
        return R.success();
    }

    @GetMapping("/email")
    @ApiOperation(value = "获取邮箱验证码")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "email", value = "邮箱地址", dataType = "String", paramType = "query"),
            }
    )
    public R getEmailCheckCode(@RequestParam() String email) {
        boolean isSuccess = checkCodeService.getEmailVerifyCode(email);
        return isSuccess ? R.success(R.SUCCESS_SEND_MESSAGE) : R.fail(R.ERROR_SEND_MESSAGE);
    }

    @PostMapping("/email")
    @ApiOperation(value = "校验邮箱")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "email", value = "邮箱地址", dataType = "String", paramType = "query"),
                    @ApiImplicitParam(name = "code", value = "验证码", dataType = "String", paramType = "query"),
            }
    )
    public R checkEmail(@RequestParam() String email, @RequestParam() String code) {
        boolean isSuccess = checkCodeService.checkEmailVerifyCode(email, code);
        return isSuccess ? R.success(R.SUCCESS_VERIFY_MESSAGE) : R.fail(R.ERROR_VERIFY_MESSAGE);
    }
}
