package com.mastertech.access.access.DTO;

import javax.validation.constraints.*;

public class AccessRequest {
    @NotBlank
    @Size(min = 3)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
