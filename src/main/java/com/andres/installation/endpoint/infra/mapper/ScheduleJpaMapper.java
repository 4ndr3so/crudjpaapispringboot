package com.andres.installation.endpoint.infra.mapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.andres.installation.endpoint.app.Schedule;
import com.andres.installation.endpoint.infra.enitities.SchedulesEntity;


@Component
public class ScheduleJpaMapper implements IScheduleJpaMapper {

    @Override
    public Schedule toDomainEntity(SchedulesEntity scheduleEntity) {
        if (scheduleEntity == null) {
            return null;
        }

        /* Schedule schedule = new Schedule();
        schedule.setId(scheduleEntity.getId());
        schedule.setIdTechnician(scheduleEntity.getIdTechnician());
        schedule.setIdOperation(scheduleEntity.getIdOperation());
        schedule.setStartOperation(scheduleEntity.getStartOperation());
        schedule.setEndOperation(scheduleEntity.getEndOperation());

        return schedule; */

        return  Schedule.builder()
                .id(scheduleEntity.getId())
                .tech(scheduleEntity.getTech())                 // ✅ map relation back
                .ope(scheduleEntity.getOpe())
                .idTechnician(scheduleEntity.getIdTechnician())
                .idOperation(scheduleEntity.getIdOperation())
                .startOperation(scheduleEntity.getStartOperation())
                .endOperation(scheduleEntity.getEndOperation())
                .build();
    }

    @Override
    public SchedulesEntity toJpaEntity(Schedule schedule) {
        if (schedule == null) {
            return null;
        }

        SchedulesEntity scheduleEntity = new SchedulesEntity();
        scheduleEntity.setId(schedule.getId());
        scheduleEntity.setTech(schedule.getTech());               // ✅ set ManyToOne
        scheduleEntity.setOpe(schedule.getOpe());                 // ✅ set ManyToOne
        scheduleEntity.setIdTechnician(schedule.getIdTechnician());
        scheduleEntity.setIdOperation(schedule.getIdOperation());
        scheduleEntity.setStartOperation(schedule.getStartOperation());
        scheduleEntity.setEndOperation(schedule.getEndOperation());

        return scheduleEntity;
    }
    
    @Override
    public List<Schedule> toDomainList(List<SchedulesEntity> entities) {
    if (entities == null) return Collections.emptyList();
    return entities.stream()
                   .map(this::toDomainEntity)
                   .collect(Collectors.toList());
}

    
    
}
