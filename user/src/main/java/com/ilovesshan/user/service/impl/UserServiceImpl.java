package com.ilovesshan.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ilovesshan.common.constants.Constants;
import com.ilovesshan.common.excpetion.CustomException;
import com.ilovesshan.common.util.*;
import com.ilovesshan.user.mapper.RegisterMapper;
import com.ilovesshan.user.mapper.UserInfoMapper;
import com.ilovesshan.user.mapper.UserMapper;
import com.ilovesshan.user.model.dto.UserLoginDto;
import com.ilovesshan.user.model.dto.UserRegisterDto;
import com.ilovesshan.user.model.po.Register;
import com.ilovesshan.user.model.po.User;
import com.ilovesshan.user.model.po.UserInfo;
import com.ilovesshan.user.model.vo.UserLoginVo;
import com.ilovesshan.user.model.vo.UserVo;
import com.ilovesshan.user.service.CheckCodeService;
import com.ilovesshan.user.service.UserService;
import com.ilovesshan.user.util.RedisCache;
import lombok.val;
import org.springframework.beans.BeanUtils;
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
    private RedisCache redisCache;

    @Resource
    private CheckCodeService checkCodeService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserInfoMapper userInfoMapper;

    @Resource
    private RegisterMapper registerMapper;

    @Override
    @Transactional(rollbackFor = {RuntimeException.class})
    public boolean singUp(UserRegisterDto userRegisterDto) {
        // 看看验证码是否正确
        boolean verifyCode = checkCodeService.checkEmailVerifyCode(userRegisterDto.getEmail(), userRegisterDto.getVerifyCode());
        if (!verifyCode) {
            throw new CustomException("验证码不正确,看准确了再试试~");
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

    @Override
    public UserLoginVo singIn(UserLoginDto userLoginDto) {
        val wrapper = new LambdaQueryWrapper<User>()
                .eq(User::getEmail, userLoginDto.getUsername())
                .or()
                .eq(User::getUsername, userLoginDto.getUsername());
        val selectedUser = userMapper.selectOne(wrapper);
        if (selectedUser == null) {
            throw new CustomException("用户信息不存在，去注册一个吧");
        }
        // 对用户传入的密码进行RSA解密
        String userPwd = RSAUtils.decryptDataOnJava(userLoginDto.getPassword(), Constants.RASKey.PRIVATE_KEY);
        // 对用户原始密码进行解密
        String dbPwd = RSAUtils.decryptDataOnJava(selectedUser.getPassword(), Constants.RASKey.PRIVATE_KEY).replaceAll(selectedUser.getSalt(), "");
        if (!dbPwd.equals(userPwd)) {
            throw new CustomException("密码输入错误啦，再试试");
        }
        // 将当前用户信息存在redis中(7天过期)
        redisCache.set(Constants.UserKey.REDIS_USER_PREFIX + selectedUser.getId(), selectedUser, Constants.TimeKey.SEVEN_DAY);

        // 只返回前端部分用户信息
        val userVo = new UserVo();
        BeanUtils.copyProperties(selectedUser, userVo);

        // 生成token
        val token = JwtUtil.generatorToken(selectedUser.getId(), selectedUser.getUsername());

        UserLoginVo userLoginVo = new UserLoginVo();
        userLoginVo.setToken(token);
        userLoginVo.setUserInfo(userVo);

        return userLoginVo;
    }

    @Override
    public UserInfo selectUserInfoById(String userId) {
        return userInfoMapper.selectById(userId);
    }
}
