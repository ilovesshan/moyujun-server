package com.ilovesshan.user.interceptor;

import com.ilovesshan.common.constants.Constants;
import com.ilovesshan.common.excpetion.AuthorizationException;
import com.ilovesshan.common.model.R;
import com.ilovesshan.common.util.JwtUtil;
import com.ilovesshan.common.util.ResponseUtil;
import com.ilovesshan.common.util.UserCache;
import com.ilovesshan.user.model.po.User;
import com.ilovesshan.user.util.RedisCache;
import org.jetbrains.annotations.NotNull;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;


/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/6
 * @description:
 */
public class SecurityHandlerInterceptor implements HandlerInterceptor {

    @Resource
    private RedisCache redisCache;

    @Override
    public boolean preHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        String authorization = request.getHeader(Constants.TokenKey.HEADER_KEY);
        // 不存在token
        if (!StringUtils.hasText(authorization)) {
            ResponseUtil.write(response, R.fail(R.ERROR_CODE_AUTHORIZATION, R.ERROR_INSUFFICIENT_AUTHENTICATION));
            return false;
        }
        String userId = JwtUtil.getUserId(authorization.replace(Constants.TokenKey.HEADER_VALUE_PREFIX, ""));
        // 去redis中查询用户信息
        User selectedUser = redisCache.get(Constants.UserKey.REDIS_USER_PREFIX + userId, User.class);
        if (Objects.isNull(selectedUser)) {
            throw new AuthorizationException(R.ERROR_INSUFFICIENT_AUTHENTICATION);
        }
        // 将当前用户ID和用户名称存在UserCache中 方便在任意地方获取
        UserCache.set("userId", userId);
        UserCache.set("username", selectedUser.getUsername());
        UserCache.set("email", selectedUser.getEmail());
        return true;
    }
}