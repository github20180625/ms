package com.sheng.store.listener;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order(200)
@Component
public class OffOrderListener implements OrderListener, Ordered {
    @Override
    public void beforeAdd() {
        System.out.println("off...");
    }

    @Override
    public int getOrder() {
        return 200;
    }
}
