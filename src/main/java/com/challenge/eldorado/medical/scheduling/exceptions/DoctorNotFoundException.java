package com.challenge.eldorado.medical.scheduling.exceptions;

import java.util.UUID;

public class DoctorNotFoundException extends RuntimeException {

    public DoctorNotFoundException(final UUID doctorId) {
        super(String.format("Doctor with id: %s not found", doctorId));
    }
}
