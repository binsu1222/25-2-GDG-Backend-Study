package com.example.shop.order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OrderRepository {

    @PersistenceContext
    private EntityManager em;
    public Order findById(Long id) {
        return em.find(Order.class, id);
    }

    public void create(Order order) {
        em.persist(order);
    }


    public List<Order> findAll() {
        return em.createQuery(
                "select o from Order o", Order.class
        ).getResultList();
    }

    public void deleteById(Long id) {
        Order order = em.find(Order.class, id);
        em.remove(order);
    }
}
