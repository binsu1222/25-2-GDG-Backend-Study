package com.example.shop.order.repository;

import com.example.shop.order.entity.Order;

import java.util.List;

public interface OrderRepository {

    Order findById(Long id);

    void create(Order order);

    List<Order> findAll();

    void deleteById(Long id);
}
