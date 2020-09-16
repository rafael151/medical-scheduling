package com.challenge.eldorado.medical.scheduling.usecase;

import com.challenge.eldorado.medical.scheduling.gateway.AppointmentGateway;
import com.challenge.eldorado.medical.scheduling.gateway.CustomerGateway;
import com.challenge.eldorado.medical.scheduling.gateway.DoctorGateway;
import com.challenge.eldorado.medical.scheduling.models.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppointmentSave {
	private final AppointmentGateway gateway;

	private final DoctorGateway doctorGateway;

	private final CustomerGateway customerGateway;

	public Appointment save(final UUID doctorId, final UUID customerId, final LocalDateTime appointmentDate) {
		final var doctor = doctorGateway.findById(doctorId);
		final var customer = customerGateway.findById(customerId);
		return gateway.save(Appointment.builder()
				.doctor(doctor)
				.customer(customer)
				.appointmentDate(appointmentDate)
				.build());
	}

}
