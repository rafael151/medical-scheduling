package com.challenge.eldorado.medical.scheduling.exceptions;

import java.util.UUID;

public class CustomerNotFoundException extends RuntimeException {

    public CustomerNotFoundException(final UUID doctorId) {
        super(String.format("Customer with id: %s not found", doctorId));
    }
}
