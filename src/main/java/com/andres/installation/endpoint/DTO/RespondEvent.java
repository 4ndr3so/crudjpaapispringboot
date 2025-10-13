package com.andres.installation.endpoint.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RespondEvent {
  private String message;

  @JsonProperty("technician_id")
  private Long technicianId;

  @JsonProperty("installation_id")
  private Long installationId;

  public RespondEvent(String message, Long technicianId, Long installationId) {
    this.message = message;
    this.technicianId = technicianId;
    this.installationId = installationId;
  }

  public String getMessage() { return message; }
  public Long getTechnicianId() { return technicianId; }
  public Long getInstallationId() { return installationId; }
}