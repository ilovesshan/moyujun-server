package com.ilovesshan.user.service;

import com.ilovesshan.user.model.dto.UserRegisterDto;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/5
 * @description:
 */
public interface UserService {
    boolean register(UserRegisterDto userRegisterDto);
}
