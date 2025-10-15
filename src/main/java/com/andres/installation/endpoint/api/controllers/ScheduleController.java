package com.andres.installation.endpoint.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.andres.installation.endpoint.api.DTO.RequestEvent;
import com.andres.installation.endpoint.api.DTO.RespondEvent;
import com.andres.installation.endpoint.api.mapper.IScheduleApiMapper;
import com.andres.installation.endpoint.app.services.IScheduleService;
import com.andres.installation.endpoint.app.services.OperationServicesImp;
import com.andres.installation.endpoint.infra.enitities.SchedulesEntity;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class ScheduleController implements ScheduleApi {

        private final IScheduleService service;
        private final IScheduleApiMapper mapper;

        @Autowired
        private OperationServicesImp operati;

        @Override
        public ResponseEntity<RespondEvent> assign(@RequestBody RequestEvent req) {
                RespondEvent res = service.instalationAssignation(req); // call ONCE

                if (res == null) {
                        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                                        .body(mapper.toGetScheduleApiResponse(
                                                        "No available technician for the requested time", null,
                                                        req.getInstalationId()));
                }

                boolean success = "Installation assigned successfully".equals(res.getMessage());
                return success
                                ? ResponseEntity.status(HttpStatus.CREATED).body(res)
                                : ResponseEntity.status(HttpStatus.CONFLICT).body(res);
        }

        @Override
        public ResponseEntity<List<SchedulesEntity>> getSchedules() {
                // TODO Auto-generated method stub
                return ResponseEntity.ok().body(operati.getSchedule());
        }

}
