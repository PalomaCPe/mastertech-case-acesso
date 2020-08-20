package com.mastertech.access.access.service;

import com.mastertech.access.access.exception.AccessNotFoundException;
import com.mastertech.access.access.model.Access;
import com.mastertech.access.access.repository.AccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessService {
    @Autowired
    AccessRepository clienteRepository;

    public Access findAccess(Integer id) {
        Optional<Access> user = clienteRepository.findById(id);
        if(!user.isPresent()) {
            throw new AccessNotFoundException();
        }
        return user.get();
    }

    public Access saveAccess(Access cliente) {

        cliente = clienteRepository.save(cliente);

        return cliente;
    }
}
