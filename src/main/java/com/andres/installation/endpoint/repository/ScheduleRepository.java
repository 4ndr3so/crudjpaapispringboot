package com.andres.installation.endpoint.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.andres.installation.endpoint.enitities.Schedules;

public interface ScheduleRepository extends JpaRepository<Schedules,Long> {
    
     // Eventos que se solapan con [start, end) (regla clásica de overlap)
  @Query("""
    select e from horarios e
    where e.technician.id = :techId
      and e.startTime < :end
      and e.endTime   > :start
  """)
  List<Schedules> findOverlapping(Long techId, Instant start, Instant end);

  List<Schedules> findByTechnicianIdOrderByStartTimeAsc(Long techId);

}
