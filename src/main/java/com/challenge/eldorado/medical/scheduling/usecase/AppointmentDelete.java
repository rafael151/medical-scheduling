package com.challenge.eldorado.medical.scheduling.usecase;

import com.challenge.eldorado.medical.scheduling.gateway.AppointmentGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentDelete {
	private final AppointmentGateway gateway;

	public void delete(final UUID id) {
		gateway.delete(id);
	}
}
