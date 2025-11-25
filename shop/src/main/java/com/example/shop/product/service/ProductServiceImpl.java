package com.example.shop.product.service;

import com.example.shop.common.exception.BadRequestException;
import com.example.shop.common.exception.NotFoundException;
import com.example.shop.common.message.ErrorMessage;
import com.example.shop.product.entity.Product;
import com.example.shop.product.repository.ProductRepository;
import com.example.shop.product.dto.ProductCreateRequest;
import com.example.shop.product.dto.ProductUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService{

    private final ProductRepository productRepository;

    @Transactional
    @Override
    public Long createProduct(ProductCreateRequest request) {
        Product prod = productRepository.findByKey(request.getPdkey());
        if (prod != null) {
            throw new BadRequestException(ErrorMessage.PRODUCT_ALREADY_EXISTS);
        }
        Product product = new Product (
                request.getPdkey(),
                request.getName(),
                request.getPrice()
        );
        productRepository.save(product);
        return product.getId();
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long productId) {
        Product product = productRepository.findById(productId);
        if (product == null) {
            throw new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND);
        }
        return product;
    }

    @Transactional
    @Override
    public void updateProduct(Long id, ProductUpdateRequest request) {
        Product product = productRepository.findById(id);
        if (product == null) {
            throw new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND);
        }
        product.updateInfo(request.getName(), request.getPrice());
    }

    @Transactional
    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id);
        if (product == null) {
            throw new NotFoundException(ErrorMessage.PRODUCT_NOT_FOUND);
        }
        productRepository.deleteById(id);
    }
}
