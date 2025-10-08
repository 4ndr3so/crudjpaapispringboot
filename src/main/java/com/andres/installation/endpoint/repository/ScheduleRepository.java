package com.andres.installation.endpoint.repository;

import java.time.Instant;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.andres.installation.endpoint.enitities.Schedules;

public interface ScheduleRepository extends JpaRepository<Schedules,Long> {
    
   

}
