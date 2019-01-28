package com.sainsburys.tu.order.web;

import com.sainsburys.tu.order.persistence.entities.Order;
import com.sainsburys.tu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

/**
 * Created by naeempatel on 28/01/2019.
 */
@RestController
public class OrderController
{
    @Autowired
    private OrderService orderService;

    @GetMapping(path = "/orders/{code}", produces = "application/json")
    public Page<Order> order(@PathVariable String code, Pageable pageable)
    {
        return orderService.findOrderByCode(code, pageable);
    }
}