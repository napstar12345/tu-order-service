package com.sainsburys.tu.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("com.sainsburys.tu.order.persistence")
public class OrderApiApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(OrderApiApplication.class, args);
    }
}
