package com.satya.healthcare.patientservice.mapper;

import com.satya.healthcare.patientservice.dto.PatientsResponseDto;
import com.satya.healthcare.patientservice.model.Patient;

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
}
