package com.andres.installation.endpoint.api.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.andres.installation.endpoint.api.DTO.RequestEvent;
import com.andres.installation.endpoint.api.DTO.RespondEvent;

import com.andres.installation.endpoint.app.Schedule;

@Component
public class ScheduleApiMapper implements IScheduleApiMapper {

    @Override
    public Schedule toDomainEntity(RequestEvent request) {
        if (request == null) {
            return null;
        }

        // Convert Instant → Date (because your domain uses Date)
        Date start = request.getStart() != null ? Date.from(request.getStart()) : null;
        Date end = request.getEnd() != null ? Date.from(request.getEnd()) : null;

       return Schedule.builder()
                .idOperation(request.getInstalationId() != null ? String.valueOf(request.getInstalationId()) : null)
                .startOperation(start)
                .endOperation(end)
                .build();
    }

    @Override
    public RespondEvent toGetScheduleApiResponse(String message, Long technicianId, Long installationId) {
        return new RespondEvent(message, technicianId, installationId);
    }

}
