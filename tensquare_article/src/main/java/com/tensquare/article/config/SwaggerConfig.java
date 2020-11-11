package com.tensquare.article.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.ArrayList;

/**
 * Swagger配置文件
 *
 * @Author : eden 2020-09-30 16:35
 */
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }

    /**
     * 配置文档信息
     * -title: 标题
     * -description: 描述
     * -version: 版本
     * -termsOfServiceUrl: 组织链接
     * -contact: 联系人信息
     * --name: 联系人名称
     * --url: 联系人访问链接
     * --email: 邮箱地址
     * -license: 许可
     * -licenseUrl: 许可链接
     * -vendorExtensions: 扩展
     *
     * @return 文档信息
     */
    private ApiInfo apiInfo() {
        return new ApiInfo(
                "十次方-文章微服务",
                "十次方项目-文章微服务接口文档",
                "v1.0",
                null,
                null,
                null,
                null,
                new ArrayList<>()
        );
    }
}
