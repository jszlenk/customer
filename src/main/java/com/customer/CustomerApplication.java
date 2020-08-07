package com.customer;

import com.customer.entity.Customer;
import com.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@Slf4j
@SpringBootApplication
public class CustomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

    @Bean
    public CommandLineRunner createAccounts(CustomerService customerService) {
        return (args) -> {
            customerService.save(new Customer("John", "Connor"));

            log.info("Customers found with findAll():");
            for (Customer account : customerService.getAll()) {
                log.info(account.toString());
            }
            log.info("-------------------------------");

            Optional<Customer> account = customerService.get(1L);
            log.info("Customer found with findById(1L):");
            log.info(account.toString());
        };
    }

}
