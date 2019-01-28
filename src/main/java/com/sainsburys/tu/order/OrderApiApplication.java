package com.sainsburys.tu.order;

import com.sainsburys.tu.order.persistence.entities.Order;
import com.sainsburys.tu.order.persistence.repositories.OrderRepository;
import com.sainsburys.tu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { WebMvcAutoConfiguration.class })
@EnableJpaRepositories("com.sainsburys.tu.order.persistence")
public class OrderApiApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(OrderApiApplication.class, args);
    }
}
