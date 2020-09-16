package com.challenge.eldorado.medical.scheduling.exceptions;

import java.util.UUID;

public class AppointmentNotFoundException extends RuntimeException {

    public AppointmentNotFoundException(final UUID appointmentId) {
        super(String.format("Appointment with id: %s not found", appointmentId));
    }
}
