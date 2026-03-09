package com.capg;

import com.capg.entity.Customer;
import com.capg.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TestHibernate {

    public static void main(String[] args) {

        EntityManager em = JPAUtil.getEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Customer customer =
                    new Customer("Siddhant", "sid@email.com", "9999999999");

            em.persist(customer);

            tx.commit();

            System.out.println("Customer Saved Successfully");

        }
        catch (Exception e) {

            tx.rollback();

            e.printStackTrace();
        }

        em.close();

        JPAUtil.closeFactory();
    }
}