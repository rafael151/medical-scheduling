package com.challenge.eldorado.medical.scheduling.gateway;

import com.challenge.eldorado.medical.scheduling.exceptions.CustomerNotFoundException;
import com.challenge.eldorado.medical.scheduling.models.Customer;
import com.challenge.eldorado.medical.scheduling.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CustomerGateway {
	private final CustomerRepository repository;

	public Customer save(final Customer customer) {
		return repository.save(customer);
	}

	public List<Customer> findAll() {
		return repository.findAll();
	}

	public Customer findById(final UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(id));
	}

	public void delete(final UUID id) {
		final var customer = findById(id);
		repository.delete(customer);
	}
}
