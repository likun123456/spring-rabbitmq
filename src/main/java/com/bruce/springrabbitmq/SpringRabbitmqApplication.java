package com.bruce.springrabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringRabbitmqApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRabbitmqApplication.class, args);
    }

}
