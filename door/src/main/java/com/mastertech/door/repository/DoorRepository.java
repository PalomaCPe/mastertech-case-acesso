package com.mastertech.door.repository;

import com.mastertech.door.model.Door;
import org.springframework.data.repository.CrudRepository;

public interface DoorRepository extends CrudRepository<Door, Integer> {
}
