package com.mastertech.access.access.client.customer;

import feign.Response;
import feign.codec.ErrorDecoder;

public class CustomerClientDecoder implements ErrorDecoder {

    private ErrorDecoder errorDecoder = new Default();

    @Override
    public Exception decode(String s, Response response) {
        if (response.status() == 404) {
            return new CustomerClientNotFoundException();
        }
        return errorDecoder.decode(s,response);
    }
}
