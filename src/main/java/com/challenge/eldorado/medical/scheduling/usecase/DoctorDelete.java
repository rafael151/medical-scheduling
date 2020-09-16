package com.challenge.eldorado.medical.scheduling.usecase;

import com.challenge.eldorado.medical.scheduling.gateway.DoctorGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorDelete {
	private final DoctorGateway gateway;

	public void delete(final UUID id) {
		gateway.delete(id);
	}
}
