package com.sainsburys.tu.order.service;


import com.sainsburys.tu.order.persistence.entities.Order;
import com.sainsburys.tu.order.persistence.repositories.OrderRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.when;

@EmbeddedKafka
@RunWith(SpringRunner.class)
public class OrdersServiceTest
{
    @InjectMocks
    private OrderService orderService;

    @Mock
    private Order mockOrder;

    @Mock
    private Page<Order> mockPage;

    @Mock
    private Pageable pageable;

    @Mock
    private OrderRepository repository;

    @Before
    public void setUp() throws Exception
    {
        when(repository.findByCode("REAL_ORDER", pageable)).thenReturn(mockPage);
    }

    @Test
    public void testFindOrderByCodeForExistingOrderInDB() throws Exception
    {
        Page<Order> orders = orderService.findOrderByCode("REAL_ORDER", pageable);
        assertEquals(mockPage, orders);
    }

    @Test
    public void testFindOrderByCodeForNonExistingOrderInDB() throws Exception
    {
        Page<Order> orders = orderService.findOrderByCode("FAKE_ORDER", pageable);
        assertNotEquals(mockPage, orders);
    }
}