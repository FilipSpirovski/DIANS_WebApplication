package mk.ukim.finki.dians_app.service;

import mk.ukim.finki.dians_app.model.Clinic;
import mk.ukim.finki.dians_app.model.enums.ClinicType;

import java.util.List;
import java.util.Optional;

public interface ClinicService {
    List<Clinic> findAllClinics();

    Optional<Clinic> findById(Integer id);

    List<Clinic> findClinicsByType(ClinicType type);
}
