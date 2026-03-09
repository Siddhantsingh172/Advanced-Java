package com.capg.service;

import com.capg.entity.*;
import com.capg.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;
import java.time.LocalDate;

public class OrderService {

    public void placeOrder(Long customerId,
                           List<Long> productIds) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Customer customer =
                    em.find(Customer.class, customerId);

            List<Product> products =
                    productIds.stream()
                    .map(id -> em.find(Product.class, id))
                    .toList();

            Order order = new Order();

            order.setCustomer(customer);

            order.setProducts(products);

            order.setTotalAmount(
                    products.stream()
                    .mapToDouble(Product::getPrice)
                    .sum()
            );

            em.persist(order);

            tx.commit();

            System.out.println("Order Placed Successfully");

        }
        catch(Exception e) {

            tx.rollback();
        }

        em.close();
    }
}