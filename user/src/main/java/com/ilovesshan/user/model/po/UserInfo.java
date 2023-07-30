package com.ilovesshan.user.model.po;


import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


@Data
@ApiModel
public class UserInfo {

    @ApiModelProperty(value = "主键ID")
    private String id;
    @ApiModelProperty(value = "用户ID")
    private String userId;
    @ApiModelProperty(value = "性别 0-未知, 1-男, 2-女")
    private long sex;
    @ApiModelProperty(value = "出生日期")
    private Date birthday;
    @ApiModelProperty(value = "头像")
    private String avatar;
    @ApiModelProperty(value = "邮箱")
    private String email;
    @ApiModelProperty(value = "擅长领域")
    private String goodAt;
    @ApiModelProperty(value = "手机号")
    private String phoneNum;
    @ApiModelProperty(value = "公司名称")
    private String company;
    @ApiModelProperty(value = "职位")
    private String position;
    @ApiModelProperty(value = "cover图")
    private String cover;
    @ApiModelProperty(value = "签名")
    private String sing;
    @ApiModelProperty(value = "所在地")
    private String location;
    @ApiModelProperty(value = "等级")
    private long level;
    @ApiModelProperty(value = "是否删除 0-正常, 1-删除")
    private long deleted;
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;
}
