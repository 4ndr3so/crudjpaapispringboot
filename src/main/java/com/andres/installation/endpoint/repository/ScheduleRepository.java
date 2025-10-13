package com.andres.installation.endpoint.repository;

import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.andres.installation.endpoint.DTO.RequestEvent;
import com.andres.installation.endpoint.DTO.RespondEvent;
import com.andres.installation.endpoint.enitities.Schedules;

public interface ScheduleRepository extends JpaRepository<Schedules, Long> {

    // Overlap: (existing.start < newEnd) AND (existing.end > newStart)
    // Overlap rule: existing.start < newEnd AND existing.end > newStart
    @Query("""
            SELECT s FROM Schedules s
            WHERE s.tech.techId = :technicianId
              AND s.startOperation < :newEnd
              AND s.endOperation > :newStart
            """)
    List<Schedules> findOverlaps(
            Long technicianId,
             Date newStart,
             Date newEnd);

    // All events for a technician (useful for tie-breaking / counting)
    @Query("SELECT s FROM Schedules s WHERE s.tech.techId = :technicianId ORDER BY s.startOperation ASC")
    List<Schedules> findAllByTechnician(@Param("technicianId") Long technicianId);

}
