package com.mastertech.access.customer.service;

import com.mastertech.access.customer.exception.CustomerNotFoundException;
import com.mastertech.access.customer.model.Customer;
import com.mastertech.access.customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    @Autowired
    CustomerRepository clienteRepository;

    public Customer findCustomer(Integer id) {
        Optional<Customer> user = clienteRepository.findById(id);
        if(!user.isPresent()) {
            throw new CustomerNotFoundException();
        }
        return user.get();
    }

    public Customer saveCustomer(Customer cliente) {

        cliente = clienteRepository.save(cliente);

        return cliente;
    }
}
