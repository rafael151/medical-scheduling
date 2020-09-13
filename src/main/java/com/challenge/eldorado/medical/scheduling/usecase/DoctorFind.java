package com.challenge.eldorado.medical.scheduling.usecase;

import com.challenge.eldorado.medical.scheduling.gateway.DoctorGateway;
import com.challenge.eldorado.medical.scheduling.models.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DoctorFind {
    private final DoctorGateway gateway;

    public List<Doctor> findAll(){
        return gateway.findAll();
    }

    public Doctor findById(final UUID id){
        return gateway.findById(id);
    }
}
