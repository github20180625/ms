package com.sheng.store.listener;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order(50)
@Component
public class CouponOrderListener implements OrderListener, Ordered {
    @Override
    public void beforeAdd() {
        System.out.println("coupon...");
    }

    @Override
    public int getOrder() {
        return 50;
    }
}
