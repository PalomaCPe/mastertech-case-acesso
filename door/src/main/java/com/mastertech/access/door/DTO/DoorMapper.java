package com.mastertech.access.door.DTO;

import com.mastertech.access.door.model.Door;
import org.springframework.stereotype.Component;

@Component
public class DoorMapper {
    public Door toDoor(DoorRequest doorRequest){
        Door door = new Door();
        door.setClassroom(doorRequest.getClassroom());
        door.setFloor(doorRequest.getFloor());
        return door;
    }

    public DoorResponse toDoorResponse(Door door) {
        DoorResponse doorResponse = new DoorResponse();
        doorResponse.setId(door.getId());
        doorResponse.setClassroom(door.getClassroom());
        doorResponse.setFloor(door.getFloor());
        return doorResponse;
    }
}
