package com.andres.installation.endpoint.app.services;

import java.util.List;
import java.util.Optional;

import com.andres.installation.endpoint.api.DTO.RequestEvent;
import com.andres.installation.endpoint.api.DTO.RespondEvent;
import com.andres.installation.endpoint.app.Schedule;


public interface IScheduleService {
    public Optional<Schedule> getSchedulesTechnician(long id);

    public List<Schedule> getSchedule();

    public void saveSchedule(Schedule schedule);

    public RespondEvent instalationAssignation(RequestEvent event);
}
