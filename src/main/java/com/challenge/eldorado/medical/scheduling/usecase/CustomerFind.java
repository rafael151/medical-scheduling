package com.challenge.eldorado.medical.scheduling.usecase;

import com.challenge.eldorado.medical.scheduling.gateway.CustomerGateway;
import com.challenge.eldorado.medical.scheduling.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CustomerFind {
	private final CustomerGateway gateway;

	public List<Customer> findAll() {
		return gateway.findAll();
	}

	public Customer findById(final UUID id) {
		return gateway.findById(id);
	}
}
