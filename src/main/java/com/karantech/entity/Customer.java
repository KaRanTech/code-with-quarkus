package com.karantech.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String name;
    public String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    public List<Order> orders;
}
