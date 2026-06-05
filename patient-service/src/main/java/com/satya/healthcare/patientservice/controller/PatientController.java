package com.satya.healthcare.patientservice.controller;

import com.satya.healthcare.patientservice.dto.PatientsResponseDto;
import com.satya.healthcare.patientservice.model.Patient;
import com.satya.healthcare.patientservice.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;
    public  PatientController(PatientService patientService){
        this.patientService=patientService;
    }
    /// get all lists of patients data;
    public ResponseEntity<List<PatientsResponseDto>> getPatients(){
        List<PatientsResponseDto> patients=patientService.getPatients();//call the service
        return ResponseEntity.ok().body(patients);

    }

}
