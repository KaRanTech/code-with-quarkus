package com.karantech.service;

import com.karantech.entity.Customer;
import com.karantech.entity.Order;
import com.karantech.repository.CustomerRepository;
import com.karantech.repository.OrderRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class OrderService {

    @Inject
    OrderRepository orderRepository;

    @Inject
    CustomerRepository customerRepository;

    public List<Order> listAll() {
        return orderRepository.listAll();
    }

    @Transactional
    public Order create(Long customerId, Order order) {
        Customer customer = customerRepository.findById(customerId);
        order.customer = customer;
        orderRepository.persist(order);
        return order;
    }

    public Order findById(Long id) {
        return orderRepository.findById(id);
    }

    @Transactional
    public Order update(Long id, Order data) {
        Order o = orderRepository.findById(id);
        o.product = data.product;
        o.amount = data.amount;
        return o;
    }

    @Transactional
    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}

