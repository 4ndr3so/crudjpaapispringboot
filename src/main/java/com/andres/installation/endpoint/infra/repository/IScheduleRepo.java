package com.andres.installation.endpoint.infra.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

import com.andres.installation.endpoint.app.Schedule;
import com.andres.installation.endpoint.infra.enitities.SchedulesEntity;
import com.andres.installation.endpoint.infra.enitities.Technician;

public interface IScheduleRepo {
    List<Schedule> findAllByTechnician(@Param("technicianId") Long technicianId);

    List<Technician> findAvailable(@Param("newStart") Date newStart,
            @Param("newEnd") Date newEnd);

    Schedule save(Schedule entity);

    Optional<Schedule> findById(Long id);

     List<SchedulesEntity> findOverlaps(
            Long technicianId,
            Date newStart,
            Date newEnd);
    
    public List<Schedule> getSchedule();

    public Optional<Schedule> getSchedulesTechnician(long id);

    
    
}
