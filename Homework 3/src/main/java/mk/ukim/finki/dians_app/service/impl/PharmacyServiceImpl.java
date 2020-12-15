package mk.ukim.finki.dians_app.service.impl;

import mk.ukim.finki.dians_app.model.Pharmacy;
import mk.ukim.finki.dians_app.repository.PharmacyRepository;
import mk.ukim.finki.dians_app.service.PharmacyService;
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

