package com.challenge.eldorado.medical.scheduling.usecase;

import com.challenge.eldorado.medical.scheduling.gateway.CustomerGateway;
import com.challenge.eldorado.medical.scheduling.models.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerSave {
	private final CustomerGateway gateway;

	public Customer save(final Customer customer) {
		return gateway.save(customer);
	}

}
