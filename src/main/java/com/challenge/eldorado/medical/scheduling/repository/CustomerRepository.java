package com.challenge.eldorado.medical.scheduling.repository;

import com.challenge.eldorado.medical.scheduling.models.Customer;
import com.challenge.eldorado.medical.scheduling.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CustomerRepository extends JpaRepository<Customer, UUID> {
}
