package com.sheng.user.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1. 定义需要自动配置的类
 * 2. 把自动配置的类在/META-INF/spring.factories中配置
 * 3. 实现ImportSelector接口并重写selectImports(),加载读取spring.factories中配置类
 * 4. @Import(DefaultEnableCustomImportSelector.class)
 *      /
 * 5. 通过自定义注解并被@Import注解
 */
@Configuration
public class CustomAutoConfiguration {

    @Bean
    public UserConfiguration userConfiguration() {
        return new UserConfiguration();
    }

    @Bean
    public RoleConfiguration roleConfiguration() {
        return new RoleConfiguration();
    }

}
