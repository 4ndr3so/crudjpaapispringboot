package com.andres.installation.endpoint.app.services;

import java.util.List;
import java.util.Optional;

import com.andres.installation.endpoint.api.DTO.RequestEvent;
import com.andres.installation.endpoint.api.DTO.RespondEvent;
import com.andres.installation.endpoint.infra.enitities.Operation;
import com.andres.installation.endpoint.infra.enitities.SchedulesEntity;
import com.andres.installation.endpoint.infra.enitities.Technician;


public interface OperationServices {

    public List<Technician> getTechnician();

    public void saveTechnician(Technician tech);

    public Optional<SchedulesEntity> getSchedulesTehcnician(long id); 

    public List<SchedulesEntity> getSchedule();

    public void saveSchedule(SchedulesEntity schedu);

    public List<Operation> getOperation();

    public void saveOperation(Operation ope);

    public RespondEvent instalationAssignation(RequestEvent event);

    public RespondEvent instalationAssignationOpt(RequestEvent event);
}