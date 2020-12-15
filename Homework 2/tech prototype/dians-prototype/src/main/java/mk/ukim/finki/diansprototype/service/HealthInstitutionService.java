package mk.ukim.finki.diansprototype.service;

import mk.ukim.finki.diansprototype.model.HealthInstitution;
import mk.ukim.finki.diansprototype.model.enums.HealthInstitutionType;
import mk.ukim.finki.diansprototype.model.exceptions.HealthInstitutionNotFoundException;

import java.util.List;

public interface HealthInstitutionService {

    List<HealthInstitution> findAll();

    HealthInstitution findById(Long id) throws HealthInstitutionNotFoundException;

    List<HealthInstitution> findByType(HealthInstitutionType type);
}
