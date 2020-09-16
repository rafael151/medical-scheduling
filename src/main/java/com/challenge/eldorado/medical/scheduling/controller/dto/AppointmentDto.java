package com.challenge.eldorado.medical.scheduling.controller.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@RequiredArgsConstructor(onConstructor = @__(@JsonCreator))
public class AppointmentDto {

	@NotNull
	final private UUID customerId;

	@NotNull
	final private LocalDateTime appointmentDate;

}
