package com.okta.developer.docker_microservices.clinicpharmacyservice.service.impl;

import com.okta.developer.docker_microservices.clinicpharmacyservice.entity.Clinic;
import com.okta.developer.docker_microservices.clinicpharmacyservice.repository.ClinicRepository;
import com.okta.developer.docker_microservices.clinicpharmacyservice.service.ClinicService;
import com.okta.developer.docker_microservices.clinicpharmacyservice.utility.ClinicType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClinicServiceImpl implements ClinicService {
    private final ClinicRepository clinicRepository;

    public ClinicServiceImpl(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    @Override
    public List<Clinic> findAllClinics() {
        return clinicRepository.findAll();
    }

    @Override
    public Optional<Clinic> findById(Integer id) {
        return clinicRepository.findById(id);
    }

    @Override
    public List<Clinic> findClinicsByType(ClinicType type) {
        return clinicRepository.findByCategory(type);
    }
}
