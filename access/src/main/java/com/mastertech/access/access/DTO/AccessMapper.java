package com.mastertech.access.access.DTO;

import com.mastertech.access.access.model.Access;
import org.springframework.stereotype.Component;

@Component
public class AccessMapper {
    public Access toAccess(AccessRequest accessRequest){
        Access access = new Access();
        access.setCustomerId(accessRequest.getCustomerId());
        access.setDoorId(accessRequest.getDoorId());
        return access;
    }

    public AccessResponse toAccessResponse(Access access) {
        AccessResponse accessResponse = new AccessResponse();
        accessResponse.setCustomerId(access.getCustomerId());
        accessResponse.setDoorId(access.getDoorId());
        return accessResponse;
    }

    public Access toAccessDetail(Integer customerId, Integer doorId) {
        Access access = new Access();
        access.setCustomerId(customerId);
        access.setDoorId(doorId);

        return access;
    }
}
