package com.andres.installation.endpoint.enitities;

import java.util.Date;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="horarios")
public class Schedules {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="techId")
    private Technician tech;

    @ManyToOne
    @JoinColumn(name="opeId")
    private Operation ope;

    public Schedules() {
    }

    public Schedules(Long id, String idTechnician, String idOperation, Date startOperation, Date endOperation) {
        this.id = id;
        this.idTechnician = idTechnician;
        this.idOperation = idOperation;
        this.startOperation = startOperation;
        this.endOperation = endOperation;
    }

    private String idTechnician;
    private String idOperation;
    private Date startOperation;

    private Date endOperation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIdTechnician() {
        return idTechnician;
    }

    public void setIdTechnician(String idTechnician) {
        this.idTechnician = idTechnician;
    }

    public String getIdOperation() {
        return idOperation;
    }

    public void setIdOperation(String idOperation) {
        this.idOperation = idOperation;
    }

    public Date getStartOperation() {
        return startOperation;
    }

    public void setStartOperation(Date startOperation) {
        this.startOperation = startOperation;
    }

    public Date getEndOperation() {
        return endOperation;
    }

    public void setEndOperation(Date endOperation) {
        this.endOperation = endOperation;
    }

}
