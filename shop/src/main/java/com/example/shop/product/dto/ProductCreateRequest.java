package com.example.shop.product.dto;

import lombok.Getter;

@Getter
public class ProductCreateRequest {

    private Long pdkey;

    private String name;

    private int price;

    public ProductCreateRequest(Long pdkey, String name, int price) {
        this.pdkey = pdkey;
        this.name = name;
        this.price = price;
    }
}
