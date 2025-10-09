package com.andres.installation.endpoint.DTO;

import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestEvent {
    private String type;

    @JsonProperty("installation_id")
    private Long instalationId;

    @JsonProperty("start_time")
    private Instant start;

    @JsonProperty("end_time")
    private Instant end;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getInstalationId() {
        return instalationId;
    }

    public void setInstalationId(Long instalationId) {
        this.instalationId = instalationId;
    }

    public Instant getStart() {
        return start;
    }

    public void setStart(Instant start) {
        this.start = start;
    }

    public Instant getEnd() {
        return end;
    }

    public void setEnd(Instant end) {
        this.end = end;
    }

    

}
