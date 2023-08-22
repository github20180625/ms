package com.sheng.user.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.health.HealthComponent;
import org.springframework.boot.actuate.health.HealthEndpoint;
import org.springframework.boot.actuate.health.Status;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "custom")
public class HealthEndpointCheck {

    @Autowired
    private HealthEndpoint healthEndpoint;

    @ReadOperation
    public void custom() {
        HealthComponent health = healthEndpoint.health();
        if (Status.UP.equals(health.getStatus())) {
            System.out.println(health.getStatus());
        }
    }

}
