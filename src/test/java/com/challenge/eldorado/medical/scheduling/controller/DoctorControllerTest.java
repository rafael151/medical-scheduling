package com.challenge.eldorado.medical.scheduling.controller;

import com.challenge.eldorado.medical.scheduling.Application;
import com.challenge.eldorado.medical.scheduling.controller.dto.DoctorDto;
import com.challenge.eldorado.medical.scheduling.models.Doctor;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.springframework.http.HttpStatus.CREATED;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class DoctorControllerTest {


    private static final String NAME = "Dr. House";
    private static final String CRM = "123";

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void ShouldSaveDoctor(){
        final DoctorDto doctorDto = new DoctorDto(NAME, CRM, null);

        final var response = restTemplate.postForEntity("/rest/doctors", doctorDto, Doctor.class);

        assertThat(response.getStatusCode(), equalTo(CREATED));
        assertThat(response.getBody().getId(), not(nullValue()));
        assertThat(response.getBody().getName(), equalTo(NAME));
        assertThat(response.getBody().getCrm(), equalTo(CRM));
    }
}