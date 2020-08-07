package com.customer.repository;

import com.customer.entity.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findById(long id);
    List<Customer> findAll();
}
