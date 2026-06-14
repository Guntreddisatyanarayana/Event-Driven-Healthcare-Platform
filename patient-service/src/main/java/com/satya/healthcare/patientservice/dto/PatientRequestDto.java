package com.satya.healthcare.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

import java.time.LocalDate;

public class PatientRequestDto {
    @NotBlank(message = "please enter a name")
    @Size(max = 100,message = "please dont exceed the 100 characters")
    private String name;
    @NotBlank(message = "Email is required")
    @Email(message = "Email Should be  valid")
    private String email;
    @NotBlank(message = "Address is required")
    private String address;
    @NotBlank(message = "Date of birth is required")
    private String dob;
    @NotBlank(message = "Registerdate is required")
    private String registrationDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

}
