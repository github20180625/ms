package com.sheng.store.store.aop;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pay")
public class IPayTest {

    private IPay iPay;

    public IPayTest(IPay iPay) {
        this.iPay = iPay;
    }

    @GetMapping("/test")
    public String test() {
        iPay.pay();
        if (iPay instanceof IPayEnhance) {
            ((WechatPayEnhance) iPay).payType();
        }
        return "success";
    }

}
