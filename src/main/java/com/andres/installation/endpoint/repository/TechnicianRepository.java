package com.andres.installation.endpoint.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andres.installation.endpoint.enitities.Technician;

public interface TechnicianRepository extends JpaRepository<Technician,Long> {
    
    
}
