package com.challenge.eldorado.medical.scheduling.repository;

import com.challenge.eldorado.medical.scheduling.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

	Optional<User> findFirstByEmail(final String email);
}
