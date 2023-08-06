package com.ilovesshan.user.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/6
 * @description:
 */
@ApiModel
@Data
public class captchaVerifyDto {
//    @Min(value = 4, message = "验证码长度为4位")
//    @Max(value = 4, message = "验证码长度为4位")
    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty(name = "code", value = "验证码", required = true)
    private String code;
}
