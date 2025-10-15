package com.andres.installation.endpoint.api.mapper;



import com.andres.installation.endpoint.api.DTO.RequestEvent;
import com.andres.installation.endpoint.api.DTO.RespondEvent;
import com.andres.installation.endpoint.app.Schedule;

public interface IScheduleApiMapper {

    Schedule toDomainEntity(RequestEvent request);
    RespondEvent toGetScheduleApiResponse(String message, Long technicianId, Long installationId);
} 
