package com.andres.installation.endpoint.enitities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.TemporalType;
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

    private Long idTechnician;
    private String idOperation;

    @jakarta.persistence.Temporal(TemporalType.TIMESTAMP)
    private Date startOperation;

    @jakarta.persistence.Temporal(TemporalType.TIMESTAMP)
    private Date endOperation;

    public Schedules() {}

    public Schedules(Long id, Long idTechnician, String idOperation, Date startOperation, Date endOperation) {
        this.id = id;
        this.idTechnician = idTechnician;
        this.idOperation = idOperation;
        this.startOperation = startOperation;
        this.endOperation = endOperation;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Technician getTech() { return tech; }
    public void setTech(Technician tech) { this.tech = tech; }

    public Operation getOpe() { return ope; }
    public void setOpe(Operation ope) { this.ope = ope; }

    public Long getIdTechnician() { return idTechnician; }
    public void setIdTechnician(Long idTechnician) { this.idTechnician = idTechnician; }

    public String getIdOperation() { return idOperation; }
    public void setIdOperation(String idOperation) { this.idOperation = idOperation; }

    public Date getStartOperation() { return startOperation; }
    public void setStartOperation(Date startOperation) { this.startOperation = startOperation; }

    public Date getEndOperation() { return endOperation; }
    public void setEndOperation(Date endOperation) { this.endOperation = endOperation; }
}