package com.andres.installation.endpoint.infra.mapper;

import java.util.List;

import com.andres.installation.endpoint.app.Schedule;
import com.andres.installation.endpoint.infra.enitities.SchedulesEntity;

public interface IScheduleJpaMapper {
    SchedulesEntity toJpaEntity(Schedule schedule);

    Schedule toDomainEntity(SchedulesEntity scheduleEntity);

    List<Schedule> toDomainList(List<SchedulesEntity> entities);
}
