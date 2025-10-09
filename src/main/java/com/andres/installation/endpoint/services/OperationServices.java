package com.andres.installation.endpoint.services;

import java.util.List;
import java.util.Optional;

import com.andres.installation.endpoint.DTO.RequestEvent;
import com.andres.installation.endpoint.DTO.RespondEvent;
import com.andres.installation.endpoint.enitities.Operation;
import com.andres.installation.endpoint.enitities.Schedules;
import com.andres.installation.endpoint.enitities.Technician;


public interface OperationServices {

    public List<Technician> getTechnician();

    public void saveTechnician(Technician tech);

    public Optional<Schedules> getSchedulesTehcnician(long id); 

    public List<Schedules> getSchedule();

    public void saveSchedule(Schedules schedu);

    public List<Operation> getOperation();

    public void saveOperation(Operation ope);

    public RespondEvent instalationAssignation(RequestEvent event);
}