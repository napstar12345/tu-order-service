package com.sainsburys.tu.order.persistence.streams;

import com.sainsburys.tu.order.service.OrderService;
import com.sainsburys.tu.order.persistence.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

/**
 * Created by naeempatel on 25/01/2019.
 */
@EnableBinding(Sink.class)
public class OrdersStreamListener
{
    @Autowired
    private OrderService orderService;

    @StreamListener(Sink.INPUT)
    public void input(Order order)
    {
        orderService.save(order);
    }
}
