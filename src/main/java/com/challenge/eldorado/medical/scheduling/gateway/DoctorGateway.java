package com.challenge.eldorado.medical.scheduling.gateway;

import com.challenge.eldorado.medical.scheduling.exceptions.DoctorNotFoundException;
import com.challenge.eldorado.medical.scheduling.models.Doctor;
import com.challenge.eldorado.medical.scheduling.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DoctorGateway {
	private final DoctorRepository repository;

	public Doctor save(final Doctor doctor) {
		return repository.save(doctor);
	}

	public List<Doctor> findAll() {
		return repository.findAll();
	}

	public Doctor findById(final UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new DoctorNotFoundException(id));
	}

	public void delete(final UUID id) {
		final var doctor = findById(id);
		repository.delete(doctor);
	}
}
