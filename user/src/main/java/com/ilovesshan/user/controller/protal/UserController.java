package com.ilovesshan.user.controller.protal;

import com.ilovesshan.common.model.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PostMapping("/singIn")
    @ApiOperation(value = "用户注册")
    public R singIn() {
        return R.success();
    }
}
