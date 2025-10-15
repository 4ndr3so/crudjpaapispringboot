package com.andres.installation.endpoint.infra.repository;

import java.util.Optional;

import com.andres.installation.endpoint.infra.enitities.Operation;


public interface IOperationRepo {
    
    Operation save(Operation entity);

    Optional<Operation> findById(Long id);

}
