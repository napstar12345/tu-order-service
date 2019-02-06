package com.sainsburys.tu.order.service;


import com.sainsburys.tu.order.persistence.entities.Order;
import org.apache.kafka.common.serialization.ByteArraySerializer;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.rule.KafkaEmbedded;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@EmbeddedKafka
@SpringBootTest
@DirtiesContext
public class OrderServiceComponentTest
{
    private static final String ORDER_TOPIC = "col_sainsburys_logistics_delivery_clothing_dispatched";
    private static final String GROUP_NAME = "tu-order-service";

    @ClassRule
    public static KafkaEmbedded embeddedKafka = new KafkaEmbedded(1, true, ORDER_TOPIC);

    @BeforeClass
    public static void setup() {
        System.setProperty("spring.cloud.stream.kafka.binder.brokers", embeddedKafka.getBrokersAsString());
        System.setProperty("spring.kafka.consumer.auto-offset-reset", "latest");
    }

    @Autowired
    private OrderService orderService;

    @Before
    public void setUp() throws Exception
    {
        Map<String, Object> senderProps = KafkaTestUtils.producerProps(embeddedKafka);
        senderProps.put("key.serializer", ByteArraySerializer.class);
        senderProps.put("value.serializer", ByteArraySerializer.class);
        DefaultKafkaProducerFactory<byte[], byte[]> pf = new DefaultKafkaProducerFactory<>(senderProps);
        KafkaTemplate<byte[], byte[]> template = new KafkaTemplate<>(pf, true);
        template.setDefaultTopic(ORDER_TOPIC);
        template.sendDefault("{  \"status\": \"collected\", \"code\": \"70010110008100T\" }".getBytes());
        Thread.sleep(10000);
    }

    @Test
    public void testIngestionOfOrdersFromKafkaToDBAndOrderLookup() throws Exception
    {
        Page<Order> page = orderService.findOrderByCode("70010110008100T", new PageRequest(0,5));
        assertNotNull(page);
        assertNotNull(page.getContent());
        assertEquals(1, page.getContent().size());
        assertEquals("70010110008100T", page.getContent().get(0).getCode());
        assertEquals("collected", page.getContent().get(0).getStatus());
    }
}