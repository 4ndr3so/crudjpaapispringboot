package com.andres.installation.endpoint.app.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.andres.installation.endpoint.api.DTO.RequestEvent;
import com.andres.installation.endpoint.api.DTO.RespondEvent;
import com.andres.installation.endpoint.infra.enitities.Operation;
import com.andres.installation.endpoint.infra.enitities.SchedulesEntity;
import com.andres.installation.endpoint.infra.enitities.Technician;
import com.andres.installation.endpoint.infra.repository.JpaOperationRepository;
import com.andres.installation.endpoint.infra.repository.JpaScheduleRepository;
import com.andres.installation.endpoint.infra.repository.JpaTechnicianRepository;

@Service
public class OperationServicesImp implements OperationServices {

    @Autowired
    private JpaTechnicianRepository technicians;

    @Autowired
    private JpaOperationRepository operations;

    @Autowired
    private JpaScheduleRepository schedules;

    private static final ZoneId CO_ZONE = ZoneId.of("America/Bogota");
    private static final SimpleDateFormat ISO = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
    static {
        ISO.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public List<Technician> getTechnician() {
        // TODO Auto-generated method stub
        return technicians.findAll();
    }

    public List<SchedulesEntity> findAllByTechnician(long id) {

        return schedules.findAllByTechnician(id);

    }

    @Override
    public Optional<SchedulesEntity> getSchedulesTehcnician(long id) {
        return schedules.findById(id);

    }

    @Override
    public List<Operation> getOperation() {
        // TODO Auto-generated method stub
        return operations.findAll();
    }

    @Override
    public List<SchedulesEntity> getSchedule() {
        // TODO Auto-generated method stub
        return schedules.findAll();
    }

    @Override
    public void saveOperation(Operation ope) {

        operations.save(ope);
    }

    @Override
    public void saveSchedule(SchedulesEntity schedu) {
        schedules.save(schedu);
    }

    @Override
    public void saveTechnician(Technician tech) {
        technicians.save(tech);
    }

    @Override
    @Transactional
    public RespondEvent instalationAssignation(RequestEvent event) {
        Instant startInstant = event.getStart();
        Instant endInstant = event.getEnd();

        Date start = Date.from(startInstant);
        Date end = Date.from(endInstant);

        ///
        if (startInstant == null || endInstant == null || !endInstant.isAfter(startInstant)) {
            return new RespondEvent("Invalid time format", null, null);
        }

        // operations
        Operation installOp = operations.findByType(event.getType() != null ? event.getType() : "installation")
                .orElseGet(() -> operations
                        .save(new Operation(null, event.getType() != null ? event.getType() : "installation")));
        Operation travelOp = operations.findByType("travel")
                .orElseGet(() -> operations.save(new Operation(null, "travel")));

        // 1 find overlap
        for (Technician tech : technicians.findAll()) {
            // is empty
            boolean free = schedules.findOverlaps(tech.getId(), start, end).isEmpty();
            if (!free)
                continue;

            // 2 set tech??
            SchedulesEntity installation = new SchedulesEntity();
            installation.setTech(tech);
            // the event always is installation
            installation.setOpe(operations.findById(installOp.getId()).orElse(null));
            installation.setStartOperation(start);
            installation.setEndOperation(end);
            installation.setIdOperation(String.valueOf(event.getInstalationId()));
            installation.setIdTechnician(tech.getId());

            // save
            schedules.save(installation);

            // save travel after 1 hour
            SchedulesEntity travel = new SchedulesEntity();
            travel.setTech(tech);
            // set the operation travel??
            travel.setOpe(operations.findById(travelOp.getId()).orElse(null));
            travel.setIdTechnician(tech.getId());
            travel.setIdOperation(String.valueOf(event.getInstalationId()));
            travel.setStartOperation(end);
            travel.setEndOperation(Date.from(endInstant.plus(Duration.ofHours(1))));

            // save
            schedules.save(travel);
            return new RespondEvent("Installation assigned successfully", tech.getId(), event.getInstalationId());
        }
        return new RespondEvent("No available technician for the requested time", null, event.getInstalationId());
    }

    @Transactional
    public RespondEvent instalationAssignationOpt(RequestEvent event) {
        Instant startInstant = event.getStart();
        Instant endInstant = event.getEnd();

        Date start = Date.from(event.getStart());
        Date end = Date.from(event.getEnd());

        ///
        if (startInstant == null || endInstant == null || !endInstant.isAfter(startInstant)) {
            return new RespondEvent("Invalid time format", null, null);
        }

        // operations
        Operation installOp = operations.findByType(event.getType() != null ? event.getType() : "installation")
                .orElseGet(() -> operations
                        .save(new Operation(null, event.getType() != null ? event.getType() : "installation")));
        Operation travelOp = operations.findByType("travel")
                .orElseGet(() -> operations.save(new Operation(null, "travel")));

        // 1 find overlap

        List<Technician> candidates = schedules.findAvailable(start, end);
        if (candidates.isEmpty()) {
            // none free
            return new RespondEvent("No available technician for the requested time", null, event.getInstalationId());
        } else {
            Technician tech = candidates.get(0); // or apply tie-breaker
        
        // is empty

        // 2 set tech??
        SchedulesEntity installation = new SchedulesEntity();
        installation.setTech(tech);
        // the event always is installation
        installation.setOpe(operations.findById(installOp.getId()).orElse(null));
        installation.setStartOperation(start);
        installation.setEndOperation(end);
        installation.setIdOperation(String.valueOf(event.getInstalationId()));
        installation.setIdTechnician(tech.getId());

        // save
        schedules.save(installation);

        // save travel after 1 hour
        SchedulesEntity travel = new SchedulesEntity();
        travel.setTech(tech);
        // set the operation travel??
        travel.setOpe(operations.findById(travelOp.getId()).orElse(null));
        travel.setIdTechnician(tech.getId());
        travel.setIdOperation(String.valueOf(event.getInstalationId()));
        travel.setStartOperation(end);
        travel.setEndOperation(Date.from(endInstant.plus(Duration.ofHours(1))));

        // save
        schedules.save(travel);
        return new RespondEvent("Installation assigned successfully", tech.getId(), event.getInstalationId());

        }
    }
}
