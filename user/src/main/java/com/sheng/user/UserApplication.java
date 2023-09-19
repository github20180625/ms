package com.sheng.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@Controller
public class UserApplication implements EnvironmentAware {

    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @GetMapping("/environment")
    @ResponseBody
    public String getEnvironment() {
        return environment.toString();
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
