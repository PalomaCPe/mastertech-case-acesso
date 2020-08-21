package com.mastertech.access.access.client.customer;

import com.mastertech.access.access.client.door.DoorClientFallback;
import feign.Feign;
import feign.RetryableException;
import feign.codec.ErrorDecoder;
import io.github.resilience4j.feign.FeignDecorators;
import io.github.resilience4j.feign.Resilience4jFeign;
import org.springframework.context.annotation.Bean;

public class CustomerClientConfiguration {
    @Bean
    public ErrorDecoder getClientNotFound(){
        return new CustomerClientDecoder();
    }

    @Bean
    public Feign.Builder builder() {
        FeignDecorators decorators = FeignDecorators.builder()
                .withFallback(new DoorClientFallback(), RetryableException.class)
                .build();

        return Resilience4jFeign.builder(decorators);
    }
}
