package com.satya.healthcare.patientservice.mapper;

import com.satya.healthcare.patientservice.dto.PatientRequestDto;
import com.satya.healthcare.patientservice.dto.PatientsResponseDto;
import com.satya.healthcare.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {
    public static PatientsResponseDto toDto(Patient patient){
        PatientsResponseDto patientDto =new PatientsResponseDto();
        patientDto.setId(patient.getId());
        patientDto.setName(patient.getName());
        patientDto.setEmail(patient.getEmail());
        patientDto.setAddress(patient.getAddress());
        patientDto.setDob(patient.getDob().toString());
        return  patientDto;

    }
    public static Patient toModel(PatientRequestDto patientRequestDto){
        Patient p1=new Patient();
        p1.setName(patientRequestDto.getName());
        p1.setEmail(patientRequestDto.getEmail());
        p1.setAddress(patientRequestDto.getAddress());
        p1.setDob(LocalDate.parse(patientRequestDto.getDob()));
        p1.setRegistrationDate(LocalDate.parse(patientRequestDto.getRegistrationDate()));
 return p1;
    }
}
