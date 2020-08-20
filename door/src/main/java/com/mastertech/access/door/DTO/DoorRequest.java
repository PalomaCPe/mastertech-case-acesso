package com.mastertech.access.door.DTO;

import javax.validation.constraints.*;

public class DoorRequest {
    private String floor;

    private String classroom;

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
