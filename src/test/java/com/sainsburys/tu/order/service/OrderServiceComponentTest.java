package com.sainsburys.tu.order.service;


import com.sainsburys.tu.order.persistence.entities.Order;
import com.sainsburys.tu.order.persistence.repositories.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@EmbeddedKafka
public class OrderServiceComponentTest
{
    @Autowired
    private OrderService orderService;

    @Before
    public void setUp() throws Exception
    {

    }

    @Test
    public void testIngestionOfOrdersFromKafkaToDB() throws Exception
    {

    }

    @Test
    public void testOrderServiceLookup() throws Exception
    {

    }
}