package com.example.shop.product.repository;

import com.example.shop.product.entity.Product;

import java.util.List;

public interface ProductRepository {

    Product findById(Long productId);

    void save(Product product);

    List<Product> findAll();

    void deleteById(Long id);

    Product findByKey(Long pdkey);
}
