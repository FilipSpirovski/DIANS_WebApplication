package mk.ukim.finki.diansprototype.service.implementation;

import mk.ukim.finki.diansprototype.model.HealthInstitution;
import mk.ukim.finki.diansprototype.model.enums.HealthInstitutionType;
import mk.ukim.finki.diansprototype.model.exceptions.HealthInstitutionNotFoundException;
import mk.ukim.finki.diansprototype.repository.InMemoryHealthInstitutionRepository;
import mk.ukim.finki.diansprototype.service.HealthInstitutionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class HealthInstitutionImplementation implements HealthInstitutionService {
    private final InMemoryHealthInstitutionRepository institutionRepository;

    public HealthInstitutionImplementation(InMemoryHealthInstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<HealthInstitution> findAll() {
        return this.institutionRepository.findAll();
    }

    @Override
    public HealthInstitution findById(Long id) throws HealthInstitutionNotFoundException {
        HealthInstitution institution = this.institutionRepository.findById(id);

        if (institution == null)
            throw new HealthInstitutionNotFoundException(id);

        return institution;
    }

    @Override
    public List<HealthInstitution> findByType(HealthInstitutionType type) {
        return this.institutionRepository.findByType(type);
    }
}
