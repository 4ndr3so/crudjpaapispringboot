package com.andres.installation.endpoint.infra.repository;

import java.util.Optional;

import com.andres.installation.endpoint.infra.enitities.Technician;

public interface ITechnicianRepo {
     Technician save(Technician entity);

    Optional<Technician> findById(Long id);
}
