package com.sheng.user.user;

import com.sheng.user.openapi.StoreApi;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController implements BeanFactoryAware {

    private BeanFactory beanFactory;

    private StoreApi storeApi;

    public UserController(StoreApi storeApi) {
        this.storeApi = storeApi;
    }

    @RequestMapping("/get")
    public String get() {
        return "get" + storeApi.get();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

}
