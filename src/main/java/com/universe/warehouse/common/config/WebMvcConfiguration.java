package com.universe.warehouse.common.config;



import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring MVC配置类,配置跨域访问
 *
 * @author
 * @version 0.0.1
 */

@Configuration
@Slf4j
public class WebMvcConfiguration implements WebMvcConfigurer {

    public WebMvcConfiguration() {
       log.debug("创建配置类对象：WebMvcConfiguration");

    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // 所有请求路径
                .allowedOriginPatterns("*") // 所有来源
                .allowedHeaders("*") // 所有请求头
                .allowedMethods("*") // 所有请求方式
                .allowCredentials(false) // 允许凭证
                .maxAge(3600); // 有效期
    }

}
