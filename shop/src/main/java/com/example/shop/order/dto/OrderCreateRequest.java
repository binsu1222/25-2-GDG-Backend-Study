package com.example.shop.order.dto;

import lombok.Getter;

@Getter
public class OrderCreateRequest {

    private Long id;

    private int totalPrice;

    private int pointUsed;

    private int cashAmount;

    public OrderCreateRequest(Long id, int totalPrice, int pointUsed, int cashAmount) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.pointUsed = pointUsed;
        this.cashAmount = cashAmount;
    }
}
