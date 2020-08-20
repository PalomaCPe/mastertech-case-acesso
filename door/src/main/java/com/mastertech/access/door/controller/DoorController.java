package com.mastertech.access.door.controller;

import com.mastertech.access.door.DTO.DoorMapper;
import com.mastertech.access.door.DTO.DoorRequest;
import com.mastertech.access.door.DTO.DoorResponse;
import com.mastertech.access.door.model.Door;
import com.mastertech.access.door.service.DoorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/door")
public class DoorController {
    @Autowired
    private DoorService doorService;

    @Autowired
    private DoorMapper doorMapper;

    @GetMapping("/{id}")
    public DoorResponse findDoor(@PathVariable int id) {
        Door doorId = doorService.findDoor(id);
        return doorMapper.toDoorResponse(doorId);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DoorResponse saveDoor(@RequestBody DoorRequest doorRequest) {
        Door door = doorMapper.toDoor(doorRequest);
        door = doorService.saveDoor(door);
        return doorMapper.toDoorResponse(door);
    }
}
