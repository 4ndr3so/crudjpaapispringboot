package com.andres.installation.endpoint.app.services;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.installation.endpoint.api.DTO.RequestEvent;
import com.andres.installation.endpoint.api.DTO.RespondEvent;
import com.andres.installation.endpoint.app.Schedule;
import com.andres.installation.endpoint.infra.enitities.Operation;
import com.andres.installation.endpoint.infra.enitities.SchedulesEntity;
import com.andres.installation.endpoint.infra.enitities.Technician;
import com.andres.installation.endpoint.infra.mapper.IScheduleJpaMapper;
import com.andres.installation.endpoint.infra.repository.IScheduleRepo;
import com.andres.installation.endpoint.infra.repository.JpaOperationRepository;
import com.andres.installation.endpoint.infra.repository.JpaTechnicianRepository;


import lombok.RequiredArgsConstructor;

@Service
public class ScheduleService implements IScheduleService {

     
    private final IScheduleRepo repository;
    private JpaTechnicianRepository technicians;
    private JpaOperationRepository operations;
    
    

     // Lombok won't add @Qualifier automatically; write an explicit constructor:
   
    public ScheduleService(
            @Qualifier("jpa") IScheduleRepo repository,
            JpaTechnicianRepository technicians,
            JpaOperationRepository operations
    ) {
        this.repository = repository;
        this.technicians = technicians;
        this.operations = operations;
    }

    @Override
    public List<Schedule> getSchedule() {
        // TODO Auto-generated method stub
        return repository.getSchedule();
    }

    @Override
    public Optional<Schedule> getSchedulesTechnician(long id) {
        // TODO Auto-generated method stub
        return repository.getSchedulesTechnician(id);
    }

    @Override
    @Transactional
    public RespondEvent instalationAssignation(RequestEvent event) {
        Instant startInstant = event.getStart();
        Instant endInstant = event.getEnd();

       
        ///
        if (startInstant == null || endInstant == null || !endInstant.isAfter(startInstant)) {
            return new RespondEvent("Invalid time format", null, null);
        }

         Date start = Date.from(startInstant);
        Date end = Date.from(endInstant);

        // operations
        Operation installOp = operations.findByType(event.getType() != null ? event.getType() : "installation")
                .orElseGet(() -> operations
                        .save(new Operation(null, event.getType() != null ? event.getType() : "installation")));
        Operation travelOp = operations.findByType("travel")
                .orElseGet(() -> operations.save(new Operation(null, "travel")));

        // 1 find overlap
        List<Technician> candidates = repository.findAvailable(start, end);
        if (candidates.isEmpty()) {
            // none free
            return new RespondEvent("No available technician for the requested time", null, event.getInstalationId());
        } else {
            Technician tech = candidates.get(0); // or apply tie-breaker

            // 2 set tech??
            Schedule installation = new Schedule();
            installation.setTech(tech);
            // the event always is installation
            installation.setOpe(installOp);
            installation.setStartOperation(start);
            installation.setEndOperation(end);
            installation.setIdOperation(String.valueOf(event.getInstalationId()));
            installation.setIdTechnician(tech.getId());

            // save
            repository.save(installation);

            // save travel after 1 hour
            Schedule travel = new Schedule();
            travel.setTech(tech);
            // set the operation travel??
            travel.setOpe(travelOp);
            travel.setIdTechnician(tech.getId());
            travel.setIdOperation(String.valueOf(event.getInstalationId()));
            travel.setStartOperation(end);
            travel.setEndOperation(Date.from(endInstant.plus(Duration.ofHours(1))));

            // save
            repository.save(travel);
            return new RespondEvent("Installation assigned successfully", tech.getId(), event.getInstalationId());
        }

        //throw new ScheduleNotFoundException(title);
       // return new RespondEvent("No available technician for the requested time", null, event.getInstalationId());
    
    }

    @Override
    public void saveSchedule(Schedule schedule) {
        // TODO Auto-generated method stub
        repository.save(schedule);
        
    }
    
}
