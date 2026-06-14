
package com.satya.healthcare.patientservice.service;

import com.satya.healthcare.patientservice.dto.PatientRequestDto;
import com.satya.healthcare.patientservice.exception.EmailAlreadyExistException;
import com.satya.healthcare.patientservice.exception.PatientNotFoundException;
import com.satya.healthcare.patientservice.mapper.PatientMapper;
import com.satya.healthcare.patientservice.model.Patient;
import com.satya.healthcare.patientservice.dto.PatientsResponseDto;
import com.satya.healthcare.patientservice.repositery.PatientRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class PatientService {
    private final PatientRepository patientRepoistery;
    public PatientService(PatientRepository patientRepoistery){
        this.patientRepoistery=patientRepoistery;
    }
    /// return the data to client through dto(because of privacy)
    public List<PatientsResponseDto> getPatients(){

        List<Patient> patients=patientRepoistery.findAll();///to find all patient
        return patients.stream().map(PatientMapper::toDto).toList();///return a list of patients
    }
    /// // create the patient
    public  PatientsResponseDto createPatients(PatientRequestDto patientRequestDto){
        if(patientRepoistery.existsByEmail(patientRequestDto.getEmail()))
        {
            throw  new EmailAlreadyExistException("A Patient Already Exist this email"+patientRequestDto.getEmail());
        }
        Patient newPatient= patientRepoistery.save(PatientMapper.toModel(patientRequestDto));///covert dto to model

        return PatientMapper.toDto(newPatient);///convert model  to dto
    }

    /// / Update the patient
    public PatientsResponseDto updatePatient(UUID id, PatientRequestDto patientRequestDto){
        Patient patient=patientRepoistery.findById(id).orElseThrow(()->new PatientNotFoundException("Patient Not Found ID"+id));///if id not found

        if(patientRepoistery.existsByEmail(patientRequestDto.getEmail()))
        {
            throw  new EmailAlreadyExistException("A Patient Already Exist this email"+patientRequestDto.getEmail());///if already exist
        }

        Patient updatePatientModel=PatientMapper.toModel(patientRequestDto);///convert a PatientsResponseDto to updatePatientModel
        updatePatientModel=patientRepoistery.save(updatePatientModel);
        return PatientMapper.toDto(updatePatientModel);///convert a updatePatientModel to PatientsResponseDto
    }
    /// /Delete Patient
    public String deletePatient(UUID id){
        Patient patientFound=patientRepoistery.findById(id).orElseThrow(()->new PatientNotFoundException("Patient Not Found ID"+id));
        patientRepoistery.deleteById(id);
        return "delete successfully";
    }


}
