package com.mastertech.access.customer.controller;

import com.mastertech.access.customer.DTO.CustomerMapper;
import com.mastertech.access.customer.DTO.CustomerRequest;
import com.mastertech.access.customer.DTO.CustomerResponse;
import com.mastertech.access.customer.model.Customer;
import com.mastertech.access.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerMapper customerMapper;

    @GetMapping("/{id}")
    public CustomerResponse findCustomer(@PathVariable int id) {
        Customer customerId = customerService.findCustomer(id);
        return customerMapper.toCustomerResponse(customerId);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerResponse saveCustomer(@RequestBody CustomerRequest customerRequest) {
        Customer customer = customerMapper.toCustomer(customerRequest);
        customer = customerService.saveCustomer(customer);
        return customerMapper.toCustomerResponse(customer);
    }
}
