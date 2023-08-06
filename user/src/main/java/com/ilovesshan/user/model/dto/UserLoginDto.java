package com.ilovesshan.user.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

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
public class UserLoginDto {
    @NotBlank(message = "用户名或邮箱不能为空")
    @ApiModelProperty(name = "username", value = "户名或邮箱", required = true)
    private String username;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(name = "password", value = "密码", required = true)
    private String password;
}
