package com.innovase.ems.controller;

import com.innovase.ems.models.Unit;
import com.innovase.ems.repositories.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UnitsController {

    @Autowired
    UnitRepository unitRepository;

    @GetMapping(value = "/units")
    public List<Unit> getAllTenants(){
        return unitRepository.findAll();
    }

}
