package com.andres.installation.endpoint.app.exceptions;

public class ScheduleNotFoundExp extends Exception {
    
    public ScheduleNotFoundExp(String prop) {
        super(String.format("Schedule with the following Id: %s does not exist", prop));
    }
}
