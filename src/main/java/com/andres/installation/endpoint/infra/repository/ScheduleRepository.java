package com.andres.installation.endpoint.infra.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.andres.installation.endpoint.app.Schedule;
import com.andres.installation.endpoint.infra.enitities.SchedulesEntity;
import com.andres.installation.endpoint.infra.enitities.Technician;
import com.andres.installation.endpoint.infra.mapper.IScheduleJpaMapper;
import com.andres.installation.endpoint.infra.mapper.ScheduleJpaMapper;

import lombok.RequiredArgsConstructor;

@Repository("jpa")
@RequiredArgsConstructor
public class ScheduleRepository implements IScheduleRepo {

    private final JpaScheduleRepository jpaScheduleRepository;
    private final IScheduleJpaMapper mapper;

    @Override
    public List<Schedule> findAllByTechnician(Long technicianId) {

        /*
         * List<SchedulesEntity> entities =
         * jpaScheduleRepository.findAllByTechnician(technicianId);
         * 
         * // Map each SchedulesEntity → Schedule
         * return entities.stream()
         * .map(mapper::toDomainEntity)
         * .collect(Collectors.toList());
         */

        return mapper.toDomainList(jpaScheduleRepository.findAllByTechnician(technicianId));
    }

    @Override
    public List<Technician> findAvailable(Date newStart, Date newEnd) {
        // TODO Auto-generated method stub
        return jpaScheduleRepository.findAvailable(newStart, newEnd);
    }

    @Override
    public Optional<Schedule> findById(Long id) {
        // TODO Auto-generated method stub
        return jpaScheduleRepository.findById(id)
                .map(mapper::toDomainEntity);
    }

    @Override
    public Schedule save(Schedule entity) {
        // TODO Auto-generated method stub
        return mapper.toDomainEntity(
                jpaScheduleRepository.save(
                        mapper.toJpaEntity(entity)
                )
        );
    }

    @Override
    public List<SchedulesEntity> findOverlaps(Long technicianId, Date newStart, Date newEnd) {
        // TODO Auto-generated method stub
        return jpaScheduleRepository.findOverlaps(technicianId, newStart, newEnd);
    }

    @Override
    public List<Schedule> getSchedule() {
        // TODO Auto-generated method stub
        return jpaScheduleRepository.findAll().stream()
                .map(mapper::toDomainEntity)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Schedule> getSchedulesTechnician(long id) {
        // TODO Auto-generated method stub
        return jpaScheduleRepository.findById(id)
                .map(mapper::toDomainEntity);
    }

}
