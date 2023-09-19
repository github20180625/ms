package com.sheng.store.store.aop;

import org.springframework.stereotype.Component;

@Component
public class WechatPayEnhance implements IPayEnhance {

    @Override
    public void payType() {
        System.out.println("this pay type is wechat...");
    }
}
