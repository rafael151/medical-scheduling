package com.challenge.eldorado.medical.scheduling.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"doctor", "customer"})
public class Appointment {

	@Id
	private UUID id;

	@JsonIgnore
	@JoinColumn(name = "doctor_id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.LAZY)
	private Doctor doctor;

	@JoinColumn(name = "customer_id", referencedColumnName = "id")
	@ManyToOne(fetch = FetchType.EAGER)
	private Customer customer;

	private LocalDateTime appointmentDate;

	private LocalDateTime createdAt;

	@PrePersist
	public void prePersist() {
		this.id = UUID.randomUUID();
		this.createdAt = LocalDateTime.now();
	}

}
