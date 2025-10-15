package com.andres.installation.endpoint.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andres.installation.endpoint.infra.enitities.Operation;

public interface JpaOperationRepository extends JpaRepository<Operation,Long> {
      Optional<Operation> findByType(String type); // "installation" or "travel"
}
