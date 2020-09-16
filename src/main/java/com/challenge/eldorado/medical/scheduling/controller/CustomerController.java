package com.challenge.eldorado.medical.scheduling.controller;

import com.challenge.eldorado.medical.scheduling.controller.dto.CustomerDto;
import com.challenge.eldorado.medical.scheduling.models.Customer;
import com.challenge.eldorado.medical.scheduling.security.Authorized;
import com.challenge.eldorado.medical.scheduling.usecase.CustomerDelete;
import com.challenge.eldorado.medical.scheduling.usecase.CustomerFind;
import com.challenge.eldorado.medical.scheduling.usecase.CustomerSave;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

	private final CustomerSave customerSave;

	private final CustomerFind customerFind;

	private final CustomerDelete customerDelete;

	@Authorized
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer save(@Valid @RequestBody final CustomerDto customerDto) {
		return customerSave.save(customerDto.toModel());
	}

	@Authorized
	@GetMapping
	public List<Customer> findAll() {
		return customerFind.findAll();
	}

	@Authorized
	@GetMapping("/{id}")
	public Customer findById(@PathVariable final UUID id) {
		return customerFind.findById(id);
	}

	@Authorized
	@PatchMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable final UUID id, @RequestBody final CustomerDto customerDto) {
		final var customer = customerFind.findById(id);
		customerSave.save(customerDto.toModel(customer));
	}

	@Authorized
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable final UUID id) {
		customerDelete.delete(id);
	}
}
