package com.innovase.ems.controller;

import com.innovase.ems.models.Tenant;
import com.innovase.ems.repositories.TenantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class TenantsController {
    @Autowired
    TenantRepository tenantRepository;

    @GetMapping(value = "/tenants")
    public List<Tenant> getAllTenants(){
        return tenantRepository.findAll();
    }
}
