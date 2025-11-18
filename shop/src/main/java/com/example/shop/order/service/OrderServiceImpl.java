package com.example.shop.order.service;

import com.example.shop.order.entity.Order;
import com.example.shop.order.repository.OrderRepository;
import com.example.shop.order.dto.OrderCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    @Transactional
    @Override
    public Long createOrder(OrderCreateRequest request) {
        Order order = orderRepository.findById(request.getId());
        if (order != null) {
            throw new RuntimeException("이미 존재하는 주문입니다." + request.getId());
        }
        orderRepository.create(order);
        return order.getId();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        Order order = orderRepository.findById(id);
        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }
        return order;
    }

    @Override
    @Transactional
    public void deleteOrder(Long id) {
        Order order = orderRepository.findById(id);
        if (order == null) {
            throw new RuntimeException("주문을 찾을 수 없습니다.");
        }
        orderRepository.deleteById(id);
    }
}
