package com.andres.installation.endpoint.controllers;


import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andres.installation.endpoint.DTO.RequestEvent;
import com.andres.installation.endpoint.DTO.RespondEvent;
import com.andres.installation.endpoint.enitities.Operation;
import com.andres.installation.endpoint.enitities.Schedules;
import com.andres.installation.endpoint.enitities.Technician;
import com.andres.installation.endpoint.services.OperationServicesImp;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/v1")
public class api {
    
    @Autowired
    private OperationServicesImp operati;

    @GetMapping("/technicians")
    public List<Technician> getTechnicians() {
        return operati.getTechnician();
    }

    @PostMapping("/technicians")
    public String postTechnician(@RequestBody Technician technician) {
        operati.saveTechnician(technician);
        return "Technician saved successfully";
    }

    @PostMapping("/operations")
    public String postOperation(@RequestBody Operation operation) {
        operati.saveOperation(operation);
        return "Operation saved successfully";
    }

    @PostMapping("/schedules")
    public String postSchedule(@RequestBody Schedules schedule) {
        operati.saveSchedule(schedule);
        return "Schedule saved successfully";
    }
    

    @GetMapping("/operations")
    public List<Operation> getOperations() {
        return operati.getOperation();
    }

    @GetMapping("/schedules")
    public List<Schedules> getSchedules() {
        return operati.getSchedule();
    }

    @PostMapping("/installation_assignments")
    public RespondEvent postInstallationAssignment(@RequestBody RequestEvent event) {
        return operati.instalationAssignation(event);
    }

    @GetMapping("/technicians/{id}/schedule")
    public Optional<Schedules> getTechnicianSchedule(@PathVariable long id) {
        return operati.getSchedulesTehcnician(id);
    }
    
    
    
}
