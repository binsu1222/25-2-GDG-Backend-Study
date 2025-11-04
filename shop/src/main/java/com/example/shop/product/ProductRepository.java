package com.example.shop.product;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository {
    @PersistenceContext
    private EntityManager em;


    public Product findById(Long productId) {
        return em.find(Product.class, productId);
    }


    public void save(Product product) {
        em.persist(product);
    }


    public List<Product> findAll() {
        return em.createQuery("select p from Product p", Product.class).getResultList();
    }


    public void deleteById(Long id) {
        Product product = em.find(Product.class, id);
        em.remove(product);
    }
}
