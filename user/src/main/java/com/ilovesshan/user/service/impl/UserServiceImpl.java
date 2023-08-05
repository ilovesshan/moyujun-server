package com.ilovesshan.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ilovesshan.common.excpetion.CustomException;
import com.ilovesshan.common.model.R;
import com.ilovesshan.common.util.UuidUtil;
import com.ilovesshan.common.util.WebUtils;
import com.ilovesshan.user.mapper.RegisterMapper;
import com.ilovesshan.user.mapper.UserInfoMapper;
import com.ilovesshan.user.mapper.UserMapper;
import com.ilovesshan.user.model.dto.UserRegisterDto;
import com.ilovesshan.user.model.po.Register;
import com.ilovesshan.user.model.po.User;
import com.ilovesshan.user.model.po.UserInfo;
import com.ilovesshan.user.service.CheckCodeService;
import com.ilovesshan.user.service.UserService;
import lombok.val;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/5
 * @description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private CheckCodeService checkCodeService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private RegisterMapper registerMapper;

    @Override
    @Transactional
    public boolean register(UserRegisterDto userRegisterDto) {
        // 看看验证码是否正确
        boolean verifyCode = checkCodeService.checkEmailVerifyCode(userRegisterDto.getEmail(), userRegisterDto.getVerifyCode());
        if (!verifyCode) {
            throw new CustomException(R.ERROR_VERIFY_MESSAGE);
        }

        // 看看邮箱是否以已经存在了
        val wrapper = new LambdaQueryWrapper<Register>().eq(Register::getEmail, userRegisterDto.getEmail());
        val selectedResult = registerMapper.selectOne(wrapper);
        if (selectedResult != null) {
            throw new CustomException("邮箱已经被注册了，换一个试试");
        }

        // 向用户详细表插入一条数据
        val userInfo = new UserInfo();
        userInfo.setId(UuidUtil.generator());
        userInfo.setEmail(userRegisterDto.getEmail());
        userInfoMapper.insert(userInfo);


        // 向用户表插入一条数据
        val user = new User();
        user.setId(UuidUtil.generator());
        user.setUserInfoId(userInfo.getId());
        user.setUsername(userRegisterDto.getUsername());
        user.setEmail(userRegisterDto.getEmail());
        user.setPassword(userRegisterDto.getPassword());
        user.setSalt(userRegisterDto.getSalt());
        userMapper.insert(user);

        // 向用户注册表插入一条数据
        val count = registerMapper.selectCount(null) + 1;
        val register = new Register();
        register.setId(UuidUtil.generator());
        register.setUserId(user.getId());
        register.setEmail(userRegisterDto.getEmail());
        register.setRegisterFrom(register.getRegisterFrom());
        register.setRegisterIp(WebUtils.getRequestIp());
        register.setTopIp(count);
        registerMapper.insert(register);

        return true;
    }
}
