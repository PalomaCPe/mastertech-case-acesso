package com.mastertech.access.door.service;

import com.mastertech.access.door.exception.DoorNotFoundException;
import com.mastertech.access.door.model.Door;
import com.mastertech.access.door.repository.DoorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DoorService {
    @Autowired
    DoorRepository doorRepository;

    public Door findDoor(Integer id) {
        Optional<Door> door = doorRepository.findById(id);
        if(!door.isPresent()) {
            throw new DoorNotFoundException();
        }
        return door.get();
    }

    public Door saveDoor(Door door) {

        door = doorRepository.save(door);

        return door;
    }
}
