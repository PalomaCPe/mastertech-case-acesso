package com.mastertech.access.access.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "access")
public class Access implements Serializable {
    private static final long serialVersionUID = -8026843854427060306L;

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private Integer doorId;

    @Column
    private Integer customerId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDoorId() {
        return doorId;
    }

    public void setDoorId(Integer doorId) {
        this.doorId = doorId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
