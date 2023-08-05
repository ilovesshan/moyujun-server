package com.ilovesshan.user.controller.protal;

import com.ilovesshan.common.model.R;
import com.ilovesshan.common.util.UuidUtil;
import com.ilovesshan.user.model.dto.UserRegisterDto;
import com.ilovesshan.user.service.UserService;
import io.swagger.annotations.Api;
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
    public R singIn(@RequestBody @Validated UserRegisterDto userRegisterDto) {
        boolean isSuccess = userService.register(userRegisterDto);
        return isSuccess ? R.success(R.SUCCESS_MESSAGE_REGISTER) : R.fail(R.ERROR_MESSAGE_REGISTER);
    }

    @GetMapping("/salt")
    @ApiOperation(value = "获取盐（字段加密）")
    public R salt() {
        return R.success(R.SUCCESS_MESSAGE, UuidUtil.generator());
    }
}
