package com.andres.installation.endpoint.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andres.installation.endpoint.enitities.Operation;

public interface OperationRepository extends JpaRepository<Operation,Long> {
      Optional<Operation> findByType(String type); // "installation" or "travel"
}
