package com.andres.installation.endpoint.enitities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="technicias")
public class Technician {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long techId;

    
    public Technician(Long id, String name) {
        this.techId = id;
        this.name = name;
    }


    public Technician() {
    }


    public Long getId() {
        return techId;
    }


    public void setId(Long id) {
        this.techId = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    private String name;

}
