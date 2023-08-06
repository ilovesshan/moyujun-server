package com.ilovesshan.user.service;

import com.ilovesshan.user.model.dto.UserLoginDto;
import com.ilovesshan.user.model.dto.UserRegisterDto;
import com.ilovesshan.user.model.vo.UserLoginVo;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/5
 * @description:
 */
public interface UserService {
    boolean singUp(UserRegisterDto userRegisterDto);

    UserLoginVo singIn(UserLoginDto userLoginDto);
}
