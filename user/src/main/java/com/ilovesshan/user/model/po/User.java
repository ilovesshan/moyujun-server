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
public class User {
    @ApiModelProperty(value = "主键ID")
    private String id;

    @ApiModelProperty(value = "用户详情ID")
    private String userInfoId;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "盐")
    private String salt;

    @ApiModelProperty(value = "是否禁用0-正常, 1-禁用")
    private long status;

    @ApiModelProperty(value = "是否删除 0-正常, 1-删除")
    private long deleted;

    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;
}
