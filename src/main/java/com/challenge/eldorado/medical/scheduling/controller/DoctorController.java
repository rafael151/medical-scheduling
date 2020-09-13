package com.challenge.eldorado.medical.scheduling.controller;

import com.challenge.eldorado.medical.scheduling.controller.dto.DoctorDto;
import com.challenge.eldorado.medical.scheduling.models.Doctor;
import com.challenge.eldorado.medical.scheduling.usecase.DoctorSave;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/rest/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorSave doctorSave;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@Valid @RequestBody final DoctorDto doctorDto){
        return doctorSave.save(doctorDto.toModel());
    }
}
