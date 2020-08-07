package com.customer;

import com.customer.entity.Customer;
import com.customer.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableDiscoveryClient
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
            for (Customer customer : customerService.getAll()) {
                log.info(customer.toString());
            }
            log.info("-------------------------------");

            Customer customer = customerService.get(2L);
            log.info("Customer found with findById(1L):");
            log.info(customer.toString());
        };
    }

}
