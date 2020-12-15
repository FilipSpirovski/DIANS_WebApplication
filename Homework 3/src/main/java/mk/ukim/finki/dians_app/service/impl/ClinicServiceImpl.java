package mk.ukim.finki.dians_app.service.impl;

import mk.ukim.finki.dians_app.model.Clinic;
import mk.ukim.finki.dians_app.model.enums.ClinicType;
import mk.ukim.finki.dians_app.repository.ClinicRepository;
import mk.ukim.finki.dians_app.service.ClinicService;
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
