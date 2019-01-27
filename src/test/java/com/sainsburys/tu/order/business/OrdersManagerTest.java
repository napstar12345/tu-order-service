package com.sainsburys.tu.order.business;


import com.sainsburys.tu.order.persistence.entities.Order;
import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.HsqlConnection;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseDataSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersManagerTest
{

    @Autowired
    private OrdersManager ordersManager;

    @Test
    public void testGetAllOrdersReturnedDataFromDatabase() throws Exception
    {
        // TODO:
    }

    @Test
    public void testSaveOrder() throws Exception
    {
        // TODO:
    }
}