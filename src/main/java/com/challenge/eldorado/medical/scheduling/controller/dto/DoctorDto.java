package com.challenge.eldorado.medical.scheduling.controller.dto;

import com.challenge.eldorado.medical.scheduling.models.Doctor;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor(onConstructor = @__(@JsonCreator))
public class DoctorDto {

    @NotNull
    @NotBlank
    final private String name;

    @NotNull
    @NotBlank
    final private String crm;

    final private String specialty;

    public Doctor toModel(){
        return Doctor.builder()
                .name(this.name)
                .crm(this.crm)
                .specialty(this.specialty)
                .build();
    }
}
