package com.example.shop.product.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ProductCreateRequest {

    @NotNull(message = "key는 필수입니다.")
    private Long pdkey;

    @NotNull(message = "이름은 필수입니다.")
    private String name;

    @NotNull(message = "가격은 필수 정보입니다.")
    private int price;

    public ProductCreateRequest(Long pdkey, String name, int price) {
        this.pdkey = pdkey;
        this.name = name;
        this.price = price;
    }
}
