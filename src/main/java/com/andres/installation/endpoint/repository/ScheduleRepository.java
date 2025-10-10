package com.andres.installation.endpoint.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.andres.installation.endpoint.enitities.Schedules;

public interface ScheduleRepository extends JpaRepository<Schedules,Long> {

    //the query should be here
    @Query("SELECT s FROM Schedules s WHERE s.technician.id = ?1 AND ((?2 BETWEEN s.startDate AND s.endDate) OR (?3 BETWEEN s.startDate AND s.endDate) OR (s.startDate BETWEEN ?2 AND ?3) OR (s.endDate BETWEEN ?2 AND ?3))")
    List<Schedules> findConflictingSchedules(Long technicianId, Instant newStartDate, Instant newEndDate);

}
