package com.challenge.eldorado.medical.scheduling.controller;

import com.challenge.eldorado.medical.scheduling.controller.dto.UserDto;
import com.challenge.eldorado.medical.scheduling.models.User;
import com.challenge.eldorado.medical.scheduling.usecase.UserLogin;
import com.challenge.eldorado.medical.scheduling.usecase.UserSave;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserSave userSave;

	private final UserLogin userLogin;

	@PostMapping("/register")
	@ResponseStatus(HttpStatus.CREATED)
	public User save(@Valid @RequestBody final UserDto userDto) {
		return userSave.save(userDto.toModel());
	}

	@PostMapping("/login")
	@ResponseStatus(HttpStatus.CREATED)
	public String login(@RequestBody final UserDto userDto) {
		return userLogin.login(userDto.getEmail(), userDto.getPassword());
	}

}
