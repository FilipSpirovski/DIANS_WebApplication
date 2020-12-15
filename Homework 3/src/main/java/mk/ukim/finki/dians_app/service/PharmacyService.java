package mk.ukim.finki.dians_app.service;

import mk.ukim.finki.dians_app.model.Pharmacy;

import java.util.List;
import java.util.Optional;

public interface PharmacyService {
    List<Pharmacy> findAllPharmacies();

    Optional<Pharmacy> findById(Integer id);

}
