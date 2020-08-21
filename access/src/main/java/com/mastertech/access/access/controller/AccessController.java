package com.mastertech.access.access.controller;

import com.mastertech.access.access.DTO.AccessMapper;
import com.mastertech.access.access.DTO.AccessRequest;
import com.mastertech.access.access.DTO.AccessResponse;
import com.mastertech.access.access.model.Access;
import com.mastertech.access.access.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/access")
public class AccessController {
    @Autowired
    private AccessService accessService;

    @Autowired
    private AccessMapper accessMapper;

    @GetMapping("/{id}")
    public AccessResponse findAccess(@PathVariable int id) {
        Access accessId = accessService.findAccess(id);
        return accessMapper.toAccessResponse(accessId);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccessResponse saveAccess(@RequestBody AccessRequest accessRequest) {
        Access access = accessMapper.toAccess(accessRequest);
        access = accessService.saveAccess(access);
        return accessMapper.toAccessResponse(access);
    }

    
    @GetMapping("/{customerId}/{doorId}")
    public AccessResponse listAccess(@PathVariable Integer customerId, @PathVariable Integer doorId) {
        Access access = accessMapper.toAccessDetail(customerId, doorId);
        access = accessService.findAccess(access);

        return accessMapper.toAccessResponse(access);
    }

    @DeleteMapping("/{customerId}/{doorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAccess(@PathVariable Integer customerId, @PathVariable Integer doorId) {
        Access access = accessMapper.toAccessDetail(customerId, doorId);
        accessService.deleteAccess(access);
    }
}
