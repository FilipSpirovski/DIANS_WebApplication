package com.okta.developer.docker_microservices.clinicpharmacyservice.service;

import com.okta.developer.docker_microservices.clinicpharmacyservice.entity.Clinic;
import com.okta.developer.docker_microservices.clinicpharmacyservice.utility.ClinicType;

import java.util.List;
import java.util.Optional;

public interface ClinicService {
    List<Clinic> findAllClinics();

    Optional<Clinic> findById(Integer id);

    List<Clinic> findClinicsByType(ClinicType type);
}
