package com.customer.controller;

import com.customer.entity.Customer;
import com.customer.service.CustomerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@Slf4j
@RefreshScope
@RestController
@RequestMapping(value = "/v1/customer/{id}", produces = { MediaType.APPLICATION_JSON_VALUE })
@RequiredArgsConstructor
public class AccountsController {

    @Value("${application.allow-get-customer}")
    private boolean allowGetAccounts;

    private final CustomerService customerService;

    @GetMapping
    public Customer getCustomer(@PathVariable long id) {
        if (!allowGetAccounts) {
            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting customer is disabled");
        }

        return customerService.get(id);
    }
}
