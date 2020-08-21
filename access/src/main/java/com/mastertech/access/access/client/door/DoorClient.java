package com.mastertech.access.access.client.door;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "door", configuration = DoorClientConfiguration.class)
public interface DoorClient {

    @GetMapping("/door/{id}")
    public DoorClientModel getById(@PathVariable Integer id);

}
