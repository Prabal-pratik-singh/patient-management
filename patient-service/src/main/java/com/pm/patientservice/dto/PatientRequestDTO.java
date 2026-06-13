package com.pm.patientservice.dto;

import com.pm.patientservice.dto.validators.CreateValidationGroup;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PatientRequestDTO {
    @NotBlank(message = "name is required")
    @Size(max = 100, message = "name cannot exceed 100 characters")
    private String name;

    @NotBlank(message = "email is req")
    @Email(message =  "Email should be valid")
    private String email;

    @NotBlank(message = "address is req")
    private String address;

    @NotBlank(message = "dob is req")
    private String dateOfBirth;

    @NotBlank(groups = CreateValidationGroup.class, message =  "registration date is req")
    private String registeredDate;

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }
}
