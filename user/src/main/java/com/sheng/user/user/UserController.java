package com.sheng.user.user;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user")
public class UserController implements BeanFactoryAware {

    private RestTemplate restTemplate;

    private BeanFactory beanFactory;

    public UserController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @RequestMapping("/get")
    public String get() {
        ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:3001/store/get", String.class);
        String storeGet = response.getBody();
        return "get" + storeGet;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }
}
