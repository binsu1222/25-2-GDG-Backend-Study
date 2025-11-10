package com.example.shop.order.dto;

public class OrderUpdateRequest {

    private Long id;

    private int totalPrice;

    private int pointUsed;

    private int cashAmount;

    public OrderUpdateRequest(Long id, int totalPrice, int pointUsed, int cashAmount) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.pointUsed = pointUsed;
        this.cashAmount = cashAmount;
    }
}
