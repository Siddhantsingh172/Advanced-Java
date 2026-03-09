package com.capg.service;

import com.capg.entity.Customer;
import com.capg.entity.Address;
import com.capg.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CustomerService {

    // Register Customer
    public void registerCustomer(String name, String email, String phone) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Customer customer = new Customer(name, email, phone);

            em.persist(customer);

            tx.commit();

            System.out.println("Customer Registered Successfully");

        }
        catch(Exception e) {

            tx.rollback();

            e.printStackTrace();
        }

        em.close();
    }

    // Add Address
    public void addAddressToCustomer(Long customerId,
                                     String street,
                                     String city,
                                     String state,
                                     String zipCode) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Customer customer = em.find(Customer.class, customerId);

            if(customer != null) {

                Address address =
                        new Address(street, city, state, zipCode);

                customer.setAddress(address);

                em.merge(customer);

                System.out.println("Address Added Successfully");
            }
            else {

                System.out.println("Customer not found");
            }

            tx.commit();
        }
        catch(Exception e) {

            tx.rollback();
            e.printStackTrace();
        }

        em.close();
    }
}