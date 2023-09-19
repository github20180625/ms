package com.sheng.user.openapi;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("store")
public interface StoreApi {

    @GetMapping("/store/get")
    String get();

}
