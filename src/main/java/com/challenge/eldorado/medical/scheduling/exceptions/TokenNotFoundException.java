package com.challenge.eldorado.medical.scheduling.exceptions;

public class TokenNotFoundException extends RuntimeException {

	public TokenNotFoundException() {
		super("Authorization header not found");
	}
}
