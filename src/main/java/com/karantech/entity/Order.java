package com.karantech.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "customer_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String product;
    public Double amount;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "customer_id")
    public Customer customer;
}

