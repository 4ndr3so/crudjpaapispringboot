package com.andres.installation.endpoint.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<Schedules> getSchedulesTehcnician(long id) {
        // TODO Auto-generated method stub
        return null;
    }



    
}
