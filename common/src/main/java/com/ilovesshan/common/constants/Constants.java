package com.ilovesshan.common.constants;

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
        String JWT_KEY = "EZzfm1n3joVCNsJl";
    }


    interface AesKey {
        String SECRET_KEY = "0af0f9761cc34f8MIICdQIBADANBgkqhkiG9cb9c3658d8eb2ae29";
        String AES = "AES";
        String CHARSET_NAME = "UTF-8";
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

        long SEVEN_DAY = 7 * ONE_DAY;
    }

    interface RASKey {
        String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkkZqLrNOdBRB7kuUIF1hbksb0jETgvhoA6slB9ps6Zd35m1tPFj7M6wCCDX+0HYagP965+p68wskFxNVJ23+jAPKKbeBqRA6z3FFS5dt+ofYm8czaVJzk6TVZxc1bcuG9227ZyG7mpuoF+TxsgDgJdJ9RkKeNlM5pQ5ZffSZX6kARsE+y3P+6WQh73+/FZdVx+AeMdquOxyblK6fwxY5ObLXtn6zH2yw1BKMM1YmaWBb9QYCuR9J7O5vRo9ibJPFvEHvi4AlernDBliXAdEAgvK2wCKr/UR6D8VgEg7qbfd3oE2Ba7vZKFwhMq8N2L3UyNIKGuCGKpTHm6U/i303ywIDAQAB";

        String PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCSRmous050FEHuS5QgXWFuSxvSMROC+GgDqyUH2mzpl3fmbW08WPszrAIINf7QdhqA/3rn6nrzCyQXE1Unbf6MA8opt4GpEDrPcUVLl236h9ibxzNpUnOTpNVnFzVty4b3bbtnIbuam6gX5PGyAOAl0n1GQp42UzmlDll99JlfqQBGwT7Lc/7pZCHvf78Vl1XH4B4x2q47HJuUrp/DFjk5ste2frMfbLDUEowzViZpYFv1BgK5H0ns7m9Gj2Jsk8W8Qe+LgCV6ucMGWJcB0QCC8rbAIqv9RHoPxWASDupt93egTYFru9koXCEyrw3YvdTI0goa4IYqlMebpT+LfTfLAgMBAAECggEAJYDeSpj4fXSQLuu7z8yBZYjmWi7xBLxx1rbzqJ7NG9sVB8R4pGdgCLCKWNaXPZV6WCaouXt6CISLvUrco15lTDrQg3+kQ9eAbJ1rGeV6ciiQVeht+wwDzBAQEv11WnA7a4b77IZOlmZgY7f0bCIjVi8wpWoBLIaMGhCiy1OCW28S/AzAjmLLMgOBXoGoc8ZptRJFNZG9rdiSq5DSb4+jthjGfoolD7mooQWErFBzHlZYovMuRZl+cxtzQc4/BS6o+dSFVKZDMdMdxoiTy3Bm/UIheekMp/N+Q7oUJCUeXv6jwU6W4sHWUHT9ecKsH8At91mxqCmzL+ls2qric8LF0QKBgQDGK91MocDaVUEhPjETLh5BfoEj3FMw4rTub4B/mSqs1xf7W/qFr2sZcnlsBWkMPdt2cX2xt3qKHoadRsIhns0TMDrV9wXqs7TSEBXkeYGKts2zU0kI8Gbh2xXfwvyadLSfwyKKWBuAcN4moIxj4RTE2s7RraZFpct/DtEpLH1heQKBgQC89bRys57LeEqAkBvoaZmw2mmAUQFO0qJyUcBa0GlAVY5X8CnmE7buvumebBmRVEBeQ85CN1oQj1FATKgU28RhF1kAun70dv+VoZeZYOyHw960x5GcVNm4sxKvfUqs6GFRWgQ3+V1i0DboI8xu+DgwCa9pFzQD8uILYPB4FLk2YwKBgCPpJv0QAsaN1HOVtYboQItVxUkeT+T38BmVExAMTXNstufRzyASnbHK0L4GbPbO7soT3tcpjIci6PnvLJazFC55+u9zCBtz3TyDtbPlYNgmMDhiy0VXaw1aiig2SVgj9edNkSDIvpMT4O3XAhnHW+AgVoIgmZTdanbn1HdFnKLhAoGBAIaGIiY6rEVM6TVn4wZuD6WxiMR6ZwT3vgDHJLtCfnv3rPP8HcgXpveHYQiRCw7EvWKewTuw7mS1s3GkYVEgOEmq9oknPHTMNx8OwL/IGfx5vJZVMdvrKGluy1G2UDCS652gCTrUQ+CyPTS9L7Cc9Ft2ubOGeliJVNYm+Gt0zXrjAoGBAJvpTmYZVMp4Pc6jOw/QvWznzL8FXUey34X+2phibaxbP7PegzQiqKpeaF+E3hIVyINh+OjQ4mkI/z8Gv5h5DWgsjnmkuafpbAMrfq7p0pfkGwdRAQHWKXIYHwcvk1rmrm1TGPxvKIngFlDTjQsneFeGAJMQMsKAx4HIJyU1pEZZ";

    }
}
