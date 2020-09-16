package com.challenge.eldorado.medical.scheduling.repository;

import com.challenge.eldorado.medical.scheduling.models.Appointment;
import com.challenge.eldorado.medical.scheduling.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AppointmentRepository extends JpaRepository<Appointment, UUID> {

	List<Appointment> findAllByDoctorOrderByAppointmentDateAsc(final Doctor doctor);
}
