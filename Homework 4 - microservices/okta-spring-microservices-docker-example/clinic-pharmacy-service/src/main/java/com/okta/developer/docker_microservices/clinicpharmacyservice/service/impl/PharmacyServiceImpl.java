package com.okta.developer.docker_microservices.clinicpharmacyservice.service.impl;

import com.okta.developer.docker_microservices.clinicpharmacyservice.entity.Pharmacy;
import com.okta.developer.docker_microservices.clinicpharmacyservice.repository.PharmacyRepository;
import com.okta.developer.docker_microservices.clinicpharmacyservice.service.PharmacyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PharmacyServiceImpl implements PharmacyService {
    private final PharmacyRepository pharmacyRepository;

    public PharmacyServiceImpl(PharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public List<Pharmacy> findAllPharmacies() {
        return this.pharmacyRepository.findAll();
    }

    @Override
    public Optional<Pharmacy> findById(Integer id) {
        return this.pharmacyRepository.findById(id);
    }
}
