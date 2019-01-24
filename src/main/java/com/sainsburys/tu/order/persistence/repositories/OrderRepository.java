package com.sainsburys.tu.order.persistence.repositories;

import com.sainsburys.tu.order.persistence.entities.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {

}
