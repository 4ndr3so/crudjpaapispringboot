package com.andres.installation.endpoint.app;

import java.util.Date;

import com.andres.installation.endpoint.infra.enitities.Operation;
import com.andres.installation.endpoint.infra.enitities.Technician;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {
    private Long id;
    private Technician tech;
    private Operation ope;
    private Long idTechnician;
    private String idOperation;
    private Date startOperation;
    private Date endOperation;
}
