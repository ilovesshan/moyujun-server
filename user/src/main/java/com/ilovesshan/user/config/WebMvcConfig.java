package com.ilovesshan.user.config;

import com.ilovesshan.common.constants.Constants;
import com.ilovesshan.common.util.SystemUtil;
import com.ilovesshan.user.interceptor.SecurityHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {
    // 注入拦截器
    @Bean
    public SecurityHandlerInterceptor securityHandlerInterceptor() {
        return new SecurityHandlerInterceptor();
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/preview/**")
                .addResourceLocations(
                        "file:" + (SystemUtil.isWindows() ? Constants.AttachmentKey.ATTACHMENT_UPLOAD_WINDOWS_DEST : Constants.AttachmentKey.ATTACHMENT_UPLOAD_LINUX_DEST)
                );

    }


   // @Override
   // public void addInterceptors(InterceptorRegistry registry) {
   //     String[] whitesName = {"/user/singIn", "/user/singUp", "/captcha", "/email", "/phone", "/preview/**"};
   //     registry.addInterceptor(securityHandlerInterceptor())
   //             .addPathPatterns("/**")
   //             .excludePathPatterns(whitesName)
   //             .excludePathPatterns("/doc.html", "/webjars/**", "/img.icons/**", "/swagger-resources/**", "/v2/api-docs");
   // }
}