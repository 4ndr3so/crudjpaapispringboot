package com.andres.installation.endpoint.enitities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name="operacion")
public class Operation {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long opeId;
    
    
    public Operation() {
    }
    
    public Operation(Long id, String type) {
        this.opeId = id;
        this.type = type;
    }

    private String type;

    public Long getId() {
        return opeId;
    }

    public void setId(Long id) {
        this.opeId = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    
}
