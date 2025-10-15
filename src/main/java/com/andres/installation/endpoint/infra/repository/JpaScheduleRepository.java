package com.andres.installation.endpoint.infra.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.andres.installation.endpoint.infra.enitities.SchedulesEntity;
import com.andres.installation.endpoint.infra.enitities.Technician;

@Repository
public interface JpaScheduleRepository extends JpaRepository<SchedulesEntity, Long> {

        // Overlap: (existing.start < newEnd) AND (existing.end > newStart)
        // Overlap rule: existing.start < newEnd AND existing.end > newStart

        @Query("""
                        SELECT s FROM SchedulesEntity s
                        WHERE s.tech.techId = :technicianId
                          AND s.startOperation < :newEnd
                          AND s.endOperation > :newStart
                        """)
        List<SchedulesEntity> findOverlaps(
                        @Param("technicianId") Long technicianId,
                        @Param("newStart") Date newStart,
                        @Param("newEnd") Date newEnd);

        @Query("""
                        SELECT s FROM SchedulesEntity s
                        WHERE s.tech.techId = :technicianId
                        ORDER BY s.startOperation ASC
                        """)
        List<SchedulesEntity> findAllByTechnician(@Param("technicianId") Long technicianId);

        @Query("""
                        SELECT t
                        FROM Technician t
                        WHERE NOT EXISTS (
                          SELECT 1 FROM SchedulesEntity s
                          WHERE s.tech = t
                            AND s.startOperation < :newEnd
                            AND s.endOperation > :newStart
                        )
                        ORDER BY t.techId ASC
                        """)
        List<Technician> findAvailable(@Param("newStart") Date newStart,
                        @Param("newEnd") Date newEnd);
}
