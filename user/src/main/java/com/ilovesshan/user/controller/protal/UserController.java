package com.ilovesshan.user.controller.protal;

import com.ilovesshan.common.constants.Constants;
import com.ilovesshan.common.model.R;
import com.ilovesshan.common.util.UuidUtil;
import com.ilovesshan.user.model.dto.UserLoginDto;
import com.ilovesshan.user.model.dto.UserRegisterDto;
import com.ilovesshan.user.model.po.UserInfo;
import com.ilovesshan.user.model.vo.UserLoginVo;
import com.ilovesshan.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/7/30
 * @description:
 */
@RestController
@RequestMapping("/user")
@Api(tags = "用户模块")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/singIn")
    @ApiOperation(value = "用户注册")
    public R singUp(@RequestBody @Validated UserRegisterDto userRegisterDto) {
        boolean isSuccess = userService.singUp(userRegisterDto);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_REGISTER) : R.fail(R.ERROR_MESSAGE_REGISTER);
    }

    @PostMapping("/singUp")
    @ApiOperation(value = "用户登录")
    public R<UserLoginVo> singIn(@RequestBody @Validated UserLoginDto userLoginDto) {
        UserLoginVo userLoginVo = userService.singIn(userLoginDto);
        return R.success(R.SUCCESS_MESSAGE_LOGIN, userLoginVo);
    }


    @GetMapping("/{id}")
    @ApiOperation(value = "根据ID获取用户详细信息")
    @ApiImplicitParams(
            {
                    @ApiImplicitParam(name = "id", value = "用户详情ID", dataType = "String", paramType = "path"),
            }
    )
    public R<UserInfo> singIn(@PathVariable("id") String userId) {
        UserInfo userInfo = userService.selectUserInfoById(userId);
        return R.success(R.SUCCESS_MESSAGE_LOGIN, userInfo);
    }

    @GetMapping("/salt")
    @ApiOperation(value = "获取盐（字段加密）")
    public R<String> salt() {
        return R.success(R.SUCCESS_ACQUIRE_MESSAGE, UuidUtil.generator());
    }

    @GetMapping("/rsa")
    @ApiOperation(value = "获取公钥")
    public R<String> rsa() {
        return R.success(R.SUCCESS_ACQUIRE_MESSAGE, Constants.RASKey.PUBLIC_KEY);
    }
}
