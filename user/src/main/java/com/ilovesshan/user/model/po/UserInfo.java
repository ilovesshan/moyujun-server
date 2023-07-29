package com.ilovesshan.user.model.po;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {

    private String id;
    private String userId;
    private long sex;
    private Date birthday;
    private String avatar;
    private String email;
    private String goodAt;
    private String phoneNum;
    private String company;
    private String position;
    private String cover;
    private String sing;
    private String location;
    private long level;
    private long deleted;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;
}
