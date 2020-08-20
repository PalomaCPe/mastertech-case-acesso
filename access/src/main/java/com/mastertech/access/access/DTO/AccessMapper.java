package com.mastertech.access.access.DTO;

import com.mastertech.access.access.model.Access;
import org.springframework.stereotype.Component;

@Component
public class AccessMapper {
    public Access toAccess(AccessRequest accessRequest){
        Access access = new Access();
        access.setName(accessRequest.getName());
        return access;
    }

    public AccessResponse toAccessResponse(Access access) {
        AccessResponse accessResponse = new AccessResponse();
        accessResponse.setId(access.getId());
        accessResponse.setName(access.getName());
        return accessResponse;
    }
}
