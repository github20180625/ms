package com.sheng.store.listener;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//@Order(70)
@Component
public class BoxOrderListener implements OrderListener, Ordered {
    @Override
    public void beforeAdd() {
        System.out.println("box...");
    }

    @Override
    public int getOrder() {
        return 70;
    }
}
