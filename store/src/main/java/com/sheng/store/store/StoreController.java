package com.sheng.store.store;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.Enumeration;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/store")
public class StoreController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @RequestMapping("/get")
    @HystrixCommand(fallbackMethod = "handlerGet")
    public String get(HttpServletRequest request, HttpServletResponse response) {
        Enumeration<String> headers = request.getHeaderNames();
        Collection<String> headerNames = response.getHeaderNames();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            //
        }
        return "get";
    }

    public String handlerGet(HttpServletRequest request, HttpServletResponse response) {
        return "hystrix";
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
}
