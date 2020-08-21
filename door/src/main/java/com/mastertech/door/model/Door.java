package com.mastertech.door.model;

import javax.persistence.*;

@Entity
@Table
public class Door {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String classroom;

    @Column
    private String floor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }
}
