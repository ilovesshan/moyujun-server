package com.ilovesshan.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ilovesshan.user.model.po.User;
import org.mapstruct.Mapper;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/5
 * @description:
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
