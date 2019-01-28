package com.sainsburys.tu.order.persistence.repositories;

import com.sainsburys.tu.order.persistence.entities.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface OrderRepository extends CrudRepository<Order, Long>
{
    Page<Order> findByCode(String code, Pageable pageable);

    Page<Order> findAll(Pageable pageable);
}
