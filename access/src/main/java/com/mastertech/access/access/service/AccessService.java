package com.mastertech.access.access.service;

import com.mastertech.access.access.client.customer.CustomerClient;
import com.mastertech.access.access.client.customer.CustomerClientModel;
import com.mastertech.access.access.client.door.DoorClient;
import com.mastertech.access.access.client.door.DoorClientModel;
import com.mastertech.access.access.producer.AccessLog;
import com.mastertech.access.access.producer.AccessLogProducer;
import com.mastertech.access.access.repository.AccessRepository;
import com.mastertech.access.access.exception.AccessNotFoundException;
import com.mastertech.access.access.model.Access;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.Optional;

@Service
public class AccessService {
    @Autowired
    AccessRepository accessRepository;

    @Autowired
    DoorClient doorClient;

    @Autowired
    CustomerClient customerClient;

    @Autowired
    AccessLogProducer accessLogProducer;

    public Access findAccess(Integer id) {
        Optional<Access> access = accessRepository.findById(id);
        if(!access.isPresent()) {
            throw new AccessNotFoundException();
        }
        return access.get();
    }

    public Access saveAccess(Access access) {
        DoorClientModel door = null;
        CustomerClientModel customer = null;

        door = doorClient.getById(access.getDoorId());

        customer = customerClient.getById(access.getCustomerId());

        access.setDoorId(door.getId());
        access.setCustomerId(customer.getId());
        access = accessRepository.save(access);

        return access;
    }

    @Transactional
    public void deleteAccess(Access access) {
        DoorClientModel door = null;
        CustomerClientModel customer = null;

        door = doorClient.getById(access.getDoorId());

        customer = customerClient.getById(access.getCustomerId());

        accessRepository.removeAllByCustomerIdAndDoorId(access.getCustomerId(), access.getDoorId());
    }

    public Access findAccess(Access access) {
        DoorClientModel door = null;
        CustomerClientModel customer = null;
        AccessLog logAccess = new AccessLog();

        if(access.getCustomerId() != 8){
            logAccess.setHasAccess(Boolean.TRUE);
            logAccess.setCustomerId(access.getCustomerId());
            logAccess.setDoorId(access.getDoorId());
        }else{
            logAccess.setHasAccess(Boolean.FALSE);
            logAccess.setCustomerId(access.getCustomerId());
            logAccess.setDoorId(access.getDoorId());
        }
        accessLogProducer.sendToKafka(logAccess);

        door = doorClient.getById(access.getDoorId());

        customer = customerClient.getById(access.getCustomerId());

        accessRepository.findAllByCustomerIdAndDoorId(access.getCustomerId(), access.getCustomerId());

        return access;

    }
}
