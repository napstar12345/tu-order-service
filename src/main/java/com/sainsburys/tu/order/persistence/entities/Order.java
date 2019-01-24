package com.sainsburys.tu.order.persistence.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String status;

    protected Order()
    {
        // for JPA
    }

    public int getId()
    {
        return id;
    }

    public String getCode()
    {
        return code;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString()
    {
        return "Order{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
