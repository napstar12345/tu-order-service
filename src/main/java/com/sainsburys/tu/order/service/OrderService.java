package com.sainsburys.tu.order.service;

import com.sainsburys.tu.order.persistence.entities.Order;
import com.sainsburys.tu.order.persistence.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Component("orderService")
public class OrderService
{
    private OrderRepository repository;

    public OrderService(OrderRepository repository)
    {
        this.repository = repository;
    }

    public Page<Order> findOrderByCode(String code, Pageable pageable) {
        return repository.findByCode(code, pageable);
    }

    @Transactional
    public Order save(Order order)
    {
        return repository.save(order);
    }
}
