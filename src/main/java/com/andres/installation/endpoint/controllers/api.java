package com.andres.installation.endpoint.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andres.installation.endpoint.enitities.Technician;
import com.andres.installation.endpoint.services.OperationServicesImp;


@RestController
@RequestMapping("/api/v1")
public class api {
    
    @Autowired
    private OperationServicesImp operati;

    @GetMapping("/technicians")
    public List<Technician> getTechnicians() {
        return operati.getTechnician();
    }

    
}
