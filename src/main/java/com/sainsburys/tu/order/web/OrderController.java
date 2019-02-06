package com.sainsburys.tu.order.web;

import com.sainsburys.tu.order.persistence.entities.Order;
import com.sainsburys.tu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by naeempatel on 28/01/2019.
 */
@RestController
@RequestMapping("/orders")
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/{code}", produces = "application/json")
    public Page<Order> findOrderByCode(@PathVariable String code, Pageable pageable)
    {
        return orderService.findOrderByCode(code, pageable);
    }
}