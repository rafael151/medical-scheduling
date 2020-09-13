package com.challenge.eldorado.medical.scheduling.controller;

import com.challenge.eldorado.medical.scheduling.controller.dto.DoctorDto;
import com.challenge.eldorado.medical.scheduling.models.Doctor;
import com.challenge.eldorado.medical.scheduling.usecase.DoctorFind;
import com.challenge.eldorado.medical.scheduling.usecase.DoctorSave;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/rest/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorSave doctorSave;
    private final DoctorFind doctorFind;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor save(@Valid @RequestBody final DoctorDto doctorDto){
        return doctorSave.save(doctorDto.toModel());
    }

    @GetMapping
    public List<Doctor> findAll(){
        return doctorFind.findAll();
    }

    @GetMapping("/{id}")
    public Doctor findById(@PathVariable final UUID id){
        return doctorFind.findById(id);
    }
}
