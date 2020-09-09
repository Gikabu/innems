package com.innovase.ems.controller;

import com.innovase.ems.exception.ResourceNotFoundException;
import com.innovase.ems.models.MpesaObject;
import com.innovase.ems.models.Unit;
import com.innovase.ems.repositories.UnitRepository;
import com.innovase.ems.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MpesaController {

    @Autowired
    AuthService authService;

    @Autowired
    UnitRepository unitRepository;

    @PostMapping(value = "/validation_url")
    public MpesaObject validation(@RequestBody MpesaObject object){
        Unit unit = unitRepository.findByName(object.billRefNumber);
        System.out.print(object.transID);
        if (unit != null) {
            object.setInvoiceNumber("TEST");
            return object;
        }
        else {
            throw new ResourceNotFoundException("Account not found with id" + object.billRefNumber);
        }
    }

    @PostMapping(value = "/confirmation")
    public void confirmation(@RequestBody MpesaObject object){
        Unit unit = unitRepository.findByName(object.billRefNumber);
        System.out.print(object.transID);
        long bal = unit.getRent_balance();
        unit.setLast_payment_date(System.currentTimeMillis());
        unit.setRent_balance(bal - Long.parseLong(object.getTransAmount()));
        unitRepository.save(unit);
    }
}
