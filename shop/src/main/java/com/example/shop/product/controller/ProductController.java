package com.example.shop.product.controller;

import com.example.shop.product.entity.Product;
import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import com.example.shop.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductCreateRequest request) {
        Long productId = productService.createProduct(request);
        return ResponseEntity.created(URI.create("/products/" + productId)).build();
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/{itemId}")
    public ResponseEntity<Product> getProduct(@PathVariable Long itemId) {
        Product product = productService.getProductById(itemId);
        return ResponseEntity.ok(product);
    }

    @PatchMapping("/{itemId}")
    public ResponseEntity<Void> updateProduct(@PathVariable Long itemId, @RequestBody ProductUpdateRequest request) {
        productService.updateProduct(itemId, request);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{itemId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long itemId) {
        productService.deleteProduct(itemId);
        return ResponseEntity.noContent().build();
    }
}
