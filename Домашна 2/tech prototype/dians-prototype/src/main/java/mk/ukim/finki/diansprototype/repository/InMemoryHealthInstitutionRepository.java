package mk.ukim.finki.diansprototype.repository;

import mk.ukim.finki.diansprototype.bootstrap.DataHolder;
import mk.ukim.finki.diansprototype.model.HealthInstitution;
import mk.ukim.finki.diansprototype.model.enums.HealthInstitutionType;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class InMemoryHealthInstitutionRepository {

    public List<HealthInstitution> findAll() {
        return DataHolder.institutions;
    }

    public HealthInstitution findById(Long id) {
        return DataHolder.institutions.stream()
                .filter(institution -> institution.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<HealthInstitution> findByType(HealthInstitutionType type) {
        return DataHolder.institutions.stream()
                .filter(institution -> institution.getType().equals(type))
                .collect(Collectors.toList());
    }
}
