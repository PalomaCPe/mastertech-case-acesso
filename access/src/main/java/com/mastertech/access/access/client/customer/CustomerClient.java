package com.mastertech.access.access.client.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer", configuration = CustomerClientConfiguration.class)
public interface CustomerClient {

    @GetMapping("/customer/{id}")
    public CustomerClientModel getById(@PathVariable Integer id);

}