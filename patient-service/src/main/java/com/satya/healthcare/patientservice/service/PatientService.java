
package com.satya.healthcare.patientservice.service;

import com.satya.healthcare.patientservice.mapper.PatientMapper;
import com.satya.healthcare.patientservice.model.Patient;
import com.satya.healthcare.patientservice.dto.PatientsResponseDto;
import com.satya.healthcare.patientservice.repositery.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepoistery;
    public PatientService(PatientRepository patientRepoistery){
        this.patientRepoistery=patientRepoistery;
    }
    /// return the data to client through dto(because privacy)
    public List<PatientsResponseDto> getPatients(){
        List<Patient> patients=patientRepoistery.findAll();//to find all patient entity objects
        return patients.stream().map(PatientMapper::toDto).toList();//returninh lost of dtos to controller
    }
}
