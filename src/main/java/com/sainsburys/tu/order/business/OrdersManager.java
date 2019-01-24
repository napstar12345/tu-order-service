package com.sainsburys.tu.order.business;

import com.sainsburys.tu.order.persistence.entities.Order;
import com.sainsburys.tu.order.persistence.repositories.OrderRepository;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrdersManager
{

    private OrderRepository orderRepository;

    @Autowired
    public OrdersManager(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    public Stream<Order> getAllOrders()
    {
        return StreamSupport.stream(orderRepository.findAll().spliterator(), true);
    }
}
