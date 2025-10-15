package com.andres.installation.endpoint.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andres.installation.endpoint.infra.enitities.Technician;

public interface JpaTechnicianRepository extends JpaRepository<Technician,Long> {
    
    
}
