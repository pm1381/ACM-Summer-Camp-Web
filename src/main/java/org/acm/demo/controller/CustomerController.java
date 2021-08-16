package org.acm.demo.controller;

import org.acm.demo.domain.data.Customer;
import org.acm.demo.domain.repository.customer.CustomerRepository;
import org.acm.demo.domain.repository.customer.CustomerRepositoryImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author : Bahar Zolfaghari
 **/
@RestController
@RequestMapping("/customers")
public class CustomerController {
    private final CustomerRepository customerRepository = CustomerRepositoryImpl.getCustomerRepository();

    @GetMapping
    public List<Customer> getCustomers() {
        return customerRepository.getAllCustomers();
    }
}
