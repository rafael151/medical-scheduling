package com.challenge.eldorado.medical.scheduling.usecase;

import com.challenge.eldorado.medical.scheduling.gateway.DoctorGateway;
import com.challenge.eldorado.medical.scheduling.models.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorSave {
    private final DoctorGateway gateway;

    public Doctor save(Doctor doctor){
        return gateway.save(doctor);
    }

}
