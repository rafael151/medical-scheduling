package com.challenge.eldorado.medical.scheduling.controller.dto;

import com.challenge.eldorado.medical.scheduling.models.User;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor(onConstructor = @__(@JsonCreator))
public class UserDto {

	@NotNull
	@NotBlank
	final private String name;

	@NotNull
	@NotBlank
	final private String email;

	@NotNull
	@NotBlank
	final private String password;

	public User toModel() {
		return User.builder()
				.name(this.name)
				.email(this.email)
				.password(this.password)
				.build();
	}

}
