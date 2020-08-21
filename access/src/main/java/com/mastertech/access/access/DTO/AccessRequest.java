package com.mastertech.access.access.DTO;

import javax.persistence.Column;
import javax.validation.constraints.*;

public class AccessRequest {
    private Integer doorId;

    private Integer customerId;

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
