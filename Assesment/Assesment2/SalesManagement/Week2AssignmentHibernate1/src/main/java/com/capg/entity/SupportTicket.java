package com.capg.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "support_ticket")
public class SupportTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String issueDescription;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    public SupportTicket() {}

    public SupportTicket(String issueDescription, Order order) {
        this.issueDescription = issueDescription;
        this.order = order;
    }
}