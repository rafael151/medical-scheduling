package com.challenge.eldorado.medical.scheduling.controller.dto;

import com.challenge.eldorado.medical.scheduling.models.Customer;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static java.util.Objects.isNull;

@Getter
@RequiredArgsConstructor(onConstructor = @__(@JsonCreator))
public class CustomerDto {

	@NotNull
	@NotBlank
	final private String name;

	@NotNull
	@NotBlank
	final private String email;

	final private String specialty;

	public Customer toModel() {
		return Customer.builder()
				.name(this.name)
				.email(this.email)
				.build();
	}

	public Customer toModel(final Customer customer) {
		if (!isNull(this.name)) {
			customer.setName(this.name);
		}
		if (!isNull(this.email)) {
			customer.setEmail(this.email);
		}
		return customer;
	}
}
