package com.challenge.eldorado.medical.scheduling.usecase;

import com.challenge.eldorado.medical.scheduling.gateway.UserGateway;
import com.challenge.eldorado.medical.scheduling.models.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserSave {
	private final UserGateway gateway;

	public User save(final User user) {
		return gateway.save(user);
	}

}
