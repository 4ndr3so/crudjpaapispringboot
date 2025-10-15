package com.andres.installation.endpoint.api.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;


import com.andres.installation.endpoint.api.DTO.RequestEvent;
import com.andres.installation.endpoint.api.DTO.RespondEvent;
import com.andres.installation.endpoint.infra.enitities.SchedulesEntity;

@RequestMapping("/api/v2")
public interface ScheduleApi {
    
  
    @PostMapping("/installation_assignments")
    @ResponseStatus(HttpStatus.CREATED)
    ResponseEntity<RespondEvent> assign(@RequestBody RequestEvent req);

    @GetMapping("/schedules")
    ResponseEntity<List<SchedulesEntity>> getSchedules();

}
