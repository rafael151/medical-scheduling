package com.challenge.eldorado.medical.scheduling.controller;

import com.challenge.eldorado.medical.scheduling.controller.dto.AppointmentDto;
import com.challenge.eldorado.medical.scheduling.models.Appointment;
import com.challenge.eldorado.medical.scheduling.security.Authorized;
import com.challenge.eldorado.medical.scheduling.usecase.AppointmentDelete;
import com.challenge.eldorado.medical.scheduling.usecase.AppointmentFind;
import com.challenge.eldorado.medical.scheduling.usecase.AppointmentSave;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/doctors/{doctorId}/appointments")
@RequiredArgsConstructor
public class AppointmentController {

	private final AppointmentSave appointmentSave;

	private final AppointmentFind appointmentFind;

	private final AppointmentDelete appointmentDelete;

	@Authorized
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Appointment save(@PathVariable final UUID doctorId, @Valid @RequestBody final AppointmentDto appointmentDto) {
		return appointmentSave.save(doctorId, appointmentDto.getCustomerId(), appointmentDto.getAppointmentDate());
	}

	@Authorized
	@GetMapping
	public List<Appointment> findAll(@PathVariable final UUID doctorId) {
		return appointmentFind.findAll(doctorId);
	}

	@Authorized
	@GetMapping("/{id}")
	public Appointment findById(@PathVariable final UUID id) {
		return appointmentFind.findById(id);
	}

	@Authorized
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable final UUID id) {
		appointmentDelete.delete(id);
	}
}
