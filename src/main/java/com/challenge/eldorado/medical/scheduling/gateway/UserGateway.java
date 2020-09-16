package com.challenge.eldorado.medical.scheduling.gateway;

import com.challenge.eldorado.medical.scheduling.exceptions.UserNotFoundException;
import com.challenge.eldorado.medical.scheduling.models.User;
import com.challenge.eldorado.medical.scheduling.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserGateway {
	private final UserRepository repository;

	public User save(final User user) {
		return repository.save(user);
	}

	public User findById(final UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new UserNotFoundException(id));
	}

	public User findByEmail(final String email) {
		return repository.findFirstByEmail(email)
				.orElseThrow(() -> new UserNotFoundException(email));
	}

	public void delete(final UUID id) {
		final var user = findById(id);
		repository.delete(user);
	}
}
