package com.sainsburys.tu.order.business;


import com.sainsburys.tu.order.persistence.entities.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersManagerTest
{

    @Autowired
    private OrdersManager ordersManager;

    @Test
    public void getAllOrdersReturnedDataFromDatabase() throws Exception
    {
        List<Order> orders = ordersManager.getAllOrders().collect(Collectors.toList());
        assertFalse(orders.isEmpty());
        assertEquals(5, orders.size());
        orders.forEach(System.out::println);
    }
}