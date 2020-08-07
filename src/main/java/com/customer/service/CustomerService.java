package com.customer.service;

import com.customer.entity.Customer;
import com.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Optional<Customer> get(long id) {
        return Optional.ofNullable(customerRepository.findById(id));
    }

    public List<Customer> getAll() {
        return customerRepository.findAll();
    }

    public void save(Customer account) {
        customerRepository.save(account);
    }
}
