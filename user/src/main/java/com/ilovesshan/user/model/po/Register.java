package com.ilovesshan.user.model.po;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Register  {

    private String id;
    private String userId;
    private long registerFrom;
    private String registerIp;
    private long topIp;
    private long deleted;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;
}
