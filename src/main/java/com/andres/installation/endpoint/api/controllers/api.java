package com.andres.installation.endpoint.api.controllers;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andres.installation.endpoint.api.DTO.RequestEvent;
import com.andres.installation.endpoint.api.DTO.RespondEvent;
import com.andres.installation.endpoint.app.services.OperationServicesImp;
import com.andres.installation.endpoint.infra.enitities.Operation;
import com.andres.installation.endpoint.infra.enitities.SchedulesEntity;
import com.andres.installation.endpoint.infra.enitities.Technician;

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
    public String postSchedule(@RequestBody SchedulesEntity schedule) {
        operati.saveSchedule(schedule);
        return "Schedule saved successfully";
    }

    @GetMapping("/operations")
    public List<Operation> getOperations() {
        return operati.getOperation();
    }

    @GetMapping("/technicians/{id}/schedule")
    public List<SchedulesEntity> getTechnicianSchedule(@PathVariable long id) {
        return operati.findAllByTechnician(id);
    }

    @GetMapping("/schedules")
    public List<SchedulesEntity> getSchedules() {
        return operati.getSchedule();
    }

    @PostMapping("/installation_assignments")
    public ResponseEntity<RespondEvent> assign(@RequestBody RequestEvent req) {

        return ResponseEntity.ok(operati.instalationAssignation(req));
    }

    @PostMapping("/installation_assignments2")
    public ResponseEntity<RespondEvent> assign2(@RequestBody RequestEvent req) {

        return ResponseEntity.ok(operati.instalationAssignationOpt(req));
    }
}
