package mk.ukim.finki.dians_app.service.impl;

import mk.ukim.finki.dians_app.model.Disease;
import mk.ukim.finki.dians_app.model.enums.DiseaseType;
import mk.ukim.finki.dians_app.repository.DiseaseRepository;
import mk.ukim.finki.dians_app.service.DiseaseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseServiceImpl implements DiseaseService {
    private final DiseaseRepository diseaseRepository;

    public DiseaseServiceImpl(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @Override
    public List<Disease> findAll() {
        return this.diseaseRepository.findAll();
    }

    @Override
    public Disease findById(Long diseaseId) {
        return this.diseaseRepository.findById(diseaseId).get();
    }

    @Override
    public List<Disease> findAllByType(DiseaseType type) {
        return this.diseaseRepository.findAllByType(type);
    }
}
