package com.ilovesshan.user.model.po;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class Settings  {

    private String id;
    private String key;
    private String value;
    private String describe;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date updateTime;
}
