package com.mastertech.access.access.client.customer;

public class CustomerClientFallback implements CustomerClient {

    @Override
    public CustomerClientModel getById(Integer id) {
        throw new CustomerClientNotFoundException();
    }
}
