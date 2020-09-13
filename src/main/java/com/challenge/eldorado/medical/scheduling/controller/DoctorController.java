package com.challenge.eldorado.medical.scheduling.controller;

import com.challenge.eldorado.medical.scheduling.models.Doctor;
import com.challenge.eldorado.medical.scheduling.usecase.DoctorSave;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorSave doctorSave;

    @PostMapping
    public Doctor save(@RequestBody final Doctor doctor){
        return doctorSave.save(doctor);
    }
}
