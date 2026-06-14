package com.satya.healthcare.patientservice.controller;

import com.satya.healthcare.patientservice.dto.PatientRequestDto;
import com.satya.healthcare.patientservice.dto.PatientsResponseDto;
import com.satya.healthcare.patientservice.model.Patient;
import com.satya.healthcare.patientservice.service.PatientService;
import jakarta.validation.Valid;
import jakarta.validation.groups.Default;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientController {
    private final PatientService patientService;
    public  PatientController(PatientService patientService){
        this.patientService=patientService;
    }
    /// get all lists of patients data;
    @GetMapping
    public ResponseEntity<List<PatientsResponseDto>> getPatients(){
        List<PatientsResponseDto> patients=patientService.getPatients();//call the service
        return ResponseEntity.ok().body(patients);

    }
    @PostMapping
    public ResponseEntity<PatientsResponseDto> createPatient(@Valid @RequestBody PatientRequestDto patientRequestDto){
        PatientsResponseDto patientsResponseDto =patientService.createPatients(patientRequestDto);
        return ResponseEntity.ok().body(patientsResponseDto);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PatientsResponseDto> updatePatient(@PathVariable UUID id, @Validated({Default.class}) @RequestBody PatientRequestDto patientRequestDto){
        PatientsResponseDto patientsResponseDto=patientService.updatePatient(id,patientRequestDto);
        return ResponseEntity.ok().body(patientsResponseDto);
    }
    /// delete the patient
    @DeleteMapping("/{id}")
    public ResponseEntity<String>  deletePatient(@PathVariable UUID id){
         String deletepatient=patientService.deletePatient(id);
         return ResponseEntity.ok().body(deletepatient);
    }


}
