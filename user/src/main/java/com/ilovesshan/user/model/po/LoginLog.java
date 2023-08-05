package com.ilovesshan.user.model.po;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/5
 * @description:
 */

@Data
@ApiModel
public class LoginLog {

    @ApiModelProperty(value = "主键ID")
    private String id;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "登录IP")
    private String loginIp;

    @ApiModelProperty(value = "登录来源 0-未知, 1-Android, 2-Ios, 3-小程序, 4-Web")
    private long loginFrom;

    @ApiModelProperty(value = "是否删除 0-正常, 1-删除")
    private long deleted;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;
}
