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
public class Register {

    @ApiModelProperty(value = "主键ID")
    private String id;

    @ApiModelProperty(value = "用户ID")
    private String userId;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "注册来源 0-未知, 1-Android, 2-Ios, 3-小程序, 4-Web")
    private long registerFrom;

    @ApiModelProperty(value = "注册IP")
    private String registerIp;

    @ApiModelProperty(value = "全站排名")
    private long topIp;

    @ApiModelProperty(value = "是否删除 0-正常, 1-删除")
    private long deleted;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;
}
