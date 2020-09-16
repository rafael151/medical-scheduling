package com.challenge.eldorado.medical.scheduling.gateway;

import com.challenge.eldorado.medical.scheduling.exceptions.AppointmentNotFoundException;
import com.challenge.eldorado.medical.scheduling.models.Appointment;
import com.challenge.eldorado.medical.scheduling.models.Doctor;
import com.challenge.eldorado.medical.scheduling.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class AppointmentGateway {
	private final AppointmentRepository repository;

	public Appointment save(final Appointment appointment) {
		return repository.save(appointment);
	}

	public List<Appointment> findAll(final Doctor doctor) {
		return repository.findAllByDoctorOrderByAppointmentDateAsc(doctor);
	}

	public Appointment findById(final UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new AppointmentNotFoundException(id));
	}

	public void delete(final UUID id) {
		final var appointment = findById(id);
		repository.delete(appointment);
	}
}
