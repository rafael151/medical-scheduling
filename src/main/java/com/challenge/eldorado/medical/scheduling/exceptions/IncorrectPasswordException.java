package com.challenge.eldorado.medical.scheduling.exceptions;

public class IncorrectPasswordException extends RuntimeException {

	public IncorrectPasswordException(final String email) {
		super(String.format("Incorrect password for email: %s", email));
	}
}
