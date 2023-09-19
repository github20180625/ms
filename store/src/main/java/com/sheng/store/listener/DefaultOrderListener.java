package com.sheng.store.listener;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order(100)
@Component
public class DefaultOrderListener implements OrderListener, Ordered {
    @Override
    public void beforeAdd() {
        System.out.println("default...");
    }

    @Override
    public int getOrder() {
        return 100;
    }
}
