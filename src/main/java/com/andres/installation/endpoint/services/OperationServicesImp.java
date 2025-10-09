package com.andres.installation.endpoint.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.andres.installation.endpoint.DTO.RequestEvent;
import com.andres.installation.endpoint.DTO.RespondEvent;
import com.andres.installation.endpoint.enitities.Operation;
import com.andres.installation.endpoint.enitities.Schedules;
import com.andres.installation.endpoint.enitities.Technician;
import com.andres.installation.endpoint.repository.OperationRepository;
import com.andres.installation.endpoint.repository.ScheduleRepository;
import com.andres.installation.endpoint.repository.TechnicianRepository;

@Service
public class OperationServicesImp implements OperationServices {

    @Autowired
    private TechnicianRepository techRepo;

    @Autowired
    private OperationRepository opeRepo;

    @Autowired
    private ScheduleRepository scheduRepo;

    @Override
    public List<Technician> getTechnician() {
        // TODO Auto-generated method stub
        return techRepo.findAll();
    }

    public List<Operation> getOperationByTechnicianId(long id){

         return    null;
        
    }

    @Override
    public Optional<Schedules> getSchedulesTehcnician(long id) {
        return scheduRepo.findById(id);
        
    }

    @Override
    public List<Operation> getOperation() {
        // TODO Auto-generated method stub
        return opeRepo.findAll();
    }

    @Override
    public List<Schedules> getSchedule() {
        // TODO Auto-generated method stub
        return scheduRepo.findAll();
    }

    @Override
    public void saveOperation(Operation ope) {

        opeRepo.save(ope);
    }

    @Override
    public void saveSchedule(Schedules schedu) {
        scheduRepo.save(schedu);
    }
        
    

    @Override
    public void saveTechnician(Technician tech) {
        techRepo.save(tech);
    }

    @Override
    public RespondEvent instalationAssignation(RequestEvent event) {

        RespondEvent respond = new RespondEvent();
        respond.setMessage("Not implemented yet");
        respond.setTechnicianId(1L);
        respond.setInstalationId(event.getInstalationId());
        return respond;
    }
 
}
