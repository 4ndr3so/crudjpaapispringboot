package com.andres.installation.endpoint.infra.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.andres.installation.endpoint.app.Schedule;
import com.andres.installation.endpoint.infra.enitities.SchedulesEntity;
import com.andres.installation.endpoint.infra.enitities.Technician;

@Repository("in-memory")
public class InMemoryScheduleRepo implements IScheduleRepo {

    @Override
    public List<Schedule> findAllByTechnician(Long technicianId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Technician> findAvailable(Date newStart, Date newEnd) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }



    @Override
    public Schedule save(Schedule entity) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<SchedulesEntity> findOverlaps(Long technicianId, Date newStart, Date newEnd) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Schedule> getSchedule() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<Schedule> getSchedulesTechnician(long id) {
        // TODO Auto-generated method stub
        return Optional.empty();
    }
    
}
