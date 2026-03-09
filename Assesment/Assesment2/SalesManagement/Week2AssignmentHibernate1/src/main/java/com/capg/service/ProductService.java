package com.capg.service;

import com.capg.entity.Product;
import com.capg.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ProductService {

    public void addProduct(String name, double price) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Product product = new Product(name, price);

            em.persist(product);

            tx.commit();

            System.out.println("Product Added Successfully");

        }
        catch(Exception e) {

            tx.rollback();
            e.printStackTrace();
        }

        em.close();
    }
}