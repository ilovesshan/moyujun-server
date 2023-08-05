package com.ilovesshan.user.constants;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: ilovesshan
 * @date: 2023/8/5
 * @description:
 */
public interface Constants {
    interface UserKey {

        // redis中缓存用户信息(前缀)
        String REDIS_USER_PREFIX = "user:";

        // redis中缓存小程序用户信息(前缀)
        String REDIS_WX__USER_PREFIX = "wx:";

        // redis中缓存验证码信息(前缀)
        String REDIS_CODE_PREFIX = "code:";

        String REDIS_CODE_LIMIT_PREFIX = "code:limit:";
    }


    interface TokenKey {
        String HEADER_KEY = "Authorization";

        String HEADER_VALUE_PREFIX = "Bearer ";
    }

    interface AttachmentKey {
        // 附件上传地址(windows)
        String ATTACHMENT_UPLOAD_WINDOWS_DEST = "D:/www/myjun/upload/";

        // 附件上传地址(linux)
        String ATTACHMENT_UPLOAD_LINUX_DEST = "/home/www/myjun/upload/";

        // 文件预览前缀
        String ATTACHMENT_PREVIEW_PREFIX = "/preview/";
    }

    interface TimeKey {
        long ONE_SECONDS = 1;
        long ONE_MINUTES = 60 * ONE_SECONDS;
        long ONE_HOURS = 60 * ONE_MINUTES;
        long ONE_DAY = 24 * ONE_HOURS;
    }
}
