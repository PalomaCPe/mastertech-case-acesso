package com.mastertech.access.access.client.door;

public class DoorClientFallback implements DoorClient {

    @Override
    public DoorClientModel getById(Integer id) {
        throw new DoorClientNotFoundException();
    }
}
