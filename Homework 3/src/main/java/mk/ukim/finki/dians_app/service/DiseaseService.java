package mk.ukim.finki.dians_app.service;

import mk.ukim.finki.dians_app.model.Disease;
import mk.ukim.finki.dians_app.model.enums.DiseaseType;

import java.util.List;

public interface DiseaseService {
    List<Disease> findAll();

    Disease findById(Long diseaseId);

    List<Disease> findAllByType(DiseaseType type);
}
