package com.ilovesshan.user.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/5
 * @description:
 */

@Data
@ApiModel
public class UserLoginVo {
    @ApiModelProperty(value = "登录凭证")
    private String token;

    @ApiModelProperty(value = "用户信息")
    private UserVo userInfo;
}
