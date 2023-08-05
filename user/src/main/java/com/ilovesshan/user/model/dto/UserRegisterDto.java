package com.ilovesshan.user.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/5
 * @description:
 */

@ApiModel
@Data
public class UserRegisterDto {

    @NotBlank(message = "电子邮件不能为空")
    @Email(message = "电子邮件格式不正确")
    @ApiModelProperty(name = "email", value = "电子邮箱", required = true)
    private String email;

    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty(name = "verifyCode", value = "验证码", required = true)
    private String verifyCode;

    @NotBlank(message = "用户名不能为空")
    @ApiModelProperty(name = "username", value = "用户名", required = true)
    private String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(name = "password", value = "密码", required = true)
    private String password;

    @NotBlank(message = "盐不能为空")
    @ApiModelProperty(name = "salt", value = "盐（密码加密）", required = true)
    private String salt;

    @Min(value = 0, message = "请检查注册来源code值")
    @Max(value = 4, message = "请检查注册来源code值")
    @ApiModelProperty(name = "registerFrom", value = "注册来源 0-未知, 1-Android, 2-Ios, 3-小程序, 4-Web", required = true)
    private Long registerFrom;
}
