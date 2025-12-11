package com.karantech.service;

import com.karantech.entity.Customer;
import jakarta.enterprise.context.ApplicationScoped;
import com.karantech.repository.CustomerRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    public List<Customer> listAll() {
        return customerRepository.listAll();
    }

    @Transactional
    public Customer create(Customer c) {
        customerRepository.persist(c);
        return c;
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id);
    }

    @Transactional
    public Customer update(Long id, Customer data) {
        Customer c = customerRepository.findById(id);
        c.name = data.name;
        c.email = data.email;
        return c;
    }

    @Transactional
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }
}

