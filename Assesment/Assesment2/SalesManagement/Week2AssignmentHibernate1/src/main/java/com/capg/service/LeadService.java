package com.capg.service;

import com.capg.entity.Lead;
import com.capg.entity.SalesEmployee;
import com.capg.util.JPAUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LeadService {

    // Create Lead
    public void createLead(String name,
                           String source,
                           String contactInfo) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Lead lead = new Lead(name, source, contactInfo);

            em.persist(lead);

            tx.commit();

            System.out.println("Lead Created Successfully");

        }
        catch(Exception e) {

            tx.rollback();
        }

        em.close();
    }

    // Assign Lead
    public void assignLeadToEmployee(Long leadId,
                                     Long employeeId) {

        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Lead lead = em.find(Lead.class, leadId);

            SalesEmployee employee =
                    em.find(SalesEmployee.class, employeeId);

            if(lead != null && employee != null) {

                lead.setEmployee(employee);

                em.merge(lead);

                System.out.println("Lead Assigned Successfully");
            }

            tx.commit();
        }
        catch(Exception e) {

            tx.rollback();
        }

        em.close();
    }
}