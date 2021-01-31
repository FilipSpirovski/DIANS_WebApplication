package com.okta.developer.docker_microservices.clinicpharmacyservice.service;

import com.okta.developer.docker_microservices.clinicpharmacyservice.entity.Pharmacy;

import java.util.List;
import java.util.Optional;

public interface PharmacyService {
    List<Pharmacy> findAllPharmacies();

    Optional<Pharmacy> findById(Integer id);
}
