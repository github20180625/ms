package com.sheng.store.store.aop;

import org.springframework.stereotype.Component;

@Component
public class WechatPay implements IPay {

    @Override
    public void pay() {
        System.out.println("wechat pay...");
    }


}
