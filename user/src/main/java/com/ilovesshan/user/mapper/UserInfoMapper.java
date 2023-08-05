package com.ilovesshan.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ilovesshan.user.model.po.UserInfo;
import org.mapstruct.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/5
 * @description:
 */

@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
