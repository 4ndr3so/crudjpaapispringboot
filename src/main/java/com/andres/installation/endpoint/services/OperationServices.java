package com.andres.installation.endpoint.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.andres.installation.endpoint.enitities.Schedules;
import com.andres.installation.endpoint.enitities.Technician;
import com.andres.installation.endpoint.repository.TechnicianRepository;

public interface OperationServices {

    public List<Technician> getTechnician();

    public List<Schedules> getSchedulesTehcnician(long id); 

    
}