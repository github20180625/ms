package com.sheng.store.store;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/store")
public class StoreController {

    @RequestMapping("/get")
    @HystrixCommand(fallbackMethod = "handlerGet")
    public String get() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (Exception e) {
            //
        }
        return "get";
    }

    public String handlerGet() {
        return "hystrix";
    }


}
