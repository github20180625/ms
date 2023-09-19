package com.sheng.store.listener;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderListenerController {

    private List<OrderListener> orderListenerList;

    public OrderListenerController(List<OrderListener> orderListenerList) {
        this.orderListenerList = orderListenerList;
    }

    @GetMapping("/test")
    public String test() {
        for (OrderListener orderListener : orderListenerList) {
            orderListener.beforeAdd();
        }
        return "test";
    }

}
