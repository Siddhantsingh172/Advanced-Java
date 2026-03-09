package com.capg.service;

import com.capg.entity.*;
import com.capg.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class TicketService {

    public void raiseTicket(Long orderId,
                            String issueDescription) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Order order = em.find(Order.class, orderId);

            SupportTicket ticket =
                    new SupportTicket(issueDescription, order);

            em.persist(ticket);

            tx.commit();

            System.out.println("Ticket Raised Successfully");

        }
        catch(Exception e) {

            tx.rollback();
        }

        em.close();
    }
}