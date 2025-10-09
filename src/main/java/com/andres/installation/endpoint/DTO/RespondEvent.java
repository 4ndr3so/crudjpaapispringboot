package com.andres.installation.endpoint.DTO;

public class RespondEvent {
    private String message;

    private Long technicianId;

    private Long instalationId;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTechnicianId() {
        return technicianId;
    }

    public void setTechnicianId(Long technicianId) {
        this.technicianId = technicianId;
    }

    public Long getInstalationId() {
        return instalationId;
    }

    public void setInstalationId(Long instalationId) {
        this.instalationId = instalationId;
    }

    
}
