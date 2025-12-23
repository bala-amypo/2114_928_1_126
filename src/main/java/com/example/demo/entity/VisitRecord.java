package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class VisitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int visits;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerProfile customer;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public int getVisits() { return visits; }
    public void setVisits(int visits) { this.visits = visits; }

    public CustomerProfile getCustomer() { return customer; }
    public void setCustomer(CustomerProfile customer) { this.customer = customer; }
}
