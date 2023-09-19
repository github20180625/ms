package com.sheng.store.configuration;

import com.netflix.hystrix.HystrixCommandProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HystrixCommandConfiguration {

    @Bean
    public HystrixCommandProperties.Setter setter() {
        return HystrixCommandProperties.Setter().withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD);
    }

}
