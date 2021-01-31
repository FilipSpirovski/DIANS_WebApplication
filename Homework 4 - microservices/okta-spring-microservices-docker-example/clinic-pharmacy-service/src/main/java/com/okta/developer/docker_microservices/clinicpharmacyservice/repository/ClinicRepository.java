package com.okta.developer.docker_microservices.clinicpharmacyservice.repository;

import com.okta.developer.docker_microservices.clinicpharmacyservice.entity.Clinic;
import com.okta.developer.docker_microservices.clinicpharmacyservice.utility.ClinicType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
    List<Clinic> findByCategory(ClinicType type);
}
