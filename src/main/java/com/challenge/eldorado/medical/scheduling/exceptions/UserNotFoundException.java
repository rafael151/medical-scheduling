package com.challenge.eldorado.medical.scheduling.exceptions;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(final UUID userId) {
		super(String.format("User with id: %s not found", userId));
	}

	public UserNotFoundException(final String email) {
		super(String.format("User with email: %s not found", email));
	}
}
