/*
 * Copyright (C) 2018 Zhejiang xiaominfo Technology CO.,LTD.
 * All rights reserved.
 * Official Web Site: http://www.xiaominfo.com.
 * Developer Web Site: http://open.xiaominfo.com.
 */

package com.universe.warehouse.common.config;


import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

/**
 * 接口文档配置类
 * @author <a href="mailto:xiaoymin@foxmail.com">xiaoymin@foxmail.com</a>
 * 2020/09/18 11:04
 * @since:knife4j-spring-boot2-demo 1.0
 * http://localhost:9090/doc.html#/home
 */
@EnableSwagger2
@EnableKnife4j
@Configuration
public class Knife4jConfig {

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Predicate<RequestHandler> predicate1 = basePackage("com.universe.warehouse.controller");

        // 使用Predicates.or组合两个package的Predicate
        Predicate<RequestHandler> combinedPredicate = Predicates.or(predicate1);

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("controller接口") //分组名称
                .select()
                .apis(combinedPredicate) // 使用组合Predicate
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("接口文档")
                .termsOfServiceUrl("")

                .version("1.0")
                .build();
    }
}
