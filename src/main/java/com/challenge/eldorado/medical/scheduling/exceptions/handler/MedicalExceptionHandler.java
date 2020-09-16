package com.challenge.eldorado.medical.scheduling.exceptions.handler;

import com.challenge.eldorado.medical.scheduling.exceptions.AppointmentNotFoundException;
import com.challenge.eldorado.medical.scheduling.exceptions.CustomerNotFoundException;
import com.challenge.eldorado.medical.scheduling.exceptions.DoctorNotFoundException;
import com.challenge.eldorado.medical.scheduling.exceptions.IncorrectPasswordException;
import com.challenge.eldorado.medical.scheduling.exceptions.TokenNotFoundException;
import com.challenge.eldorado.medical.scheduling.exceptions.UserNotFoundException;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MedicalExceptionHandler {

	@ExceptionHandler({DoctorNotFoundException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleException(final DoctorNotFoundException e) {
		return e.getMessage();
	}

	@ExceptionHandler({CustomerNotFoundException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleException(final CustomerNotFoundException e) {
		return e.getMessage();
	}

	@ExceptionHandler({AppointmentNotFoundException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String handleException(final AppointmentNotFoundException e) {
		return e.getMessage();
	}

	@ExceptionHandler({UserNotFoundException.class})
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public String handleException(final UserNotFoundException e) {
		return e.getMessage();
	}

	@ExceptionHandler({IncorrectPasswordException.class})
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public String handleException(final IncorrectPasswordException e) {
		return e.getMessage();
	}

	@ExceptionHandler({TokenNotFoundException.class})
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public String handleException(final TokenNotFoundException e) {
		return e.getMessage();
	}

	@ExceptionHandler({ExpiredJwtException.class})
	@ResponseStatus(HttpStatus.UNAUTHORIZED)
	public String handleException(final ExpiredJwtException e) {
		return "Invalid token: this token is expired";
	}
}
