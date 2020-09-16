package com.challenge.eldorado.medical.scheduling.usecase;

import com.challenge.eldorado.medical.scheduling.gateway.AppointmentGateway;
import com.challenge.eldorado.medical.scheduling.gateway.DoctorGateway;
import com.challenge.eldorado.medical.scheduling.models.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentFind {
	private final AppointmentGateway gateway;

	private final DoctorGateway doctorGateway;

	@Transactional
	public List<Appointment> findAll(final UUID doctorId) {
		final var doctor = doctorGateway.findById(doctorId);
		return gateway.findAll(doctor);
	}

	public Appointment findById(final UUID id) {
		return gateway.findById(id);
	}
}
