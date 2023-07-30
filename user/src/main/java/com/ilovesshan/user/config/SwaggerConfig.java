package com.ilovesshan.user.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.ilovesshan.user.controller"))
//                .apis(RequestHandlerSelectors.basePackage("com.ilovesshan.common.model"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "MoYuJun后端API",
                "MoYuJun Server description of API.",
                "API TOS",
                "Terms of service",
                new Contact("ilovesshan", "www.ilovesshan.com", "ilovesshy@gmail.com"),
                "License of API", "API license URL", Collections.emptyList());
    }
}