package com.mastertech.access.customer.repository;

import com.mastertech.access.customer.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
