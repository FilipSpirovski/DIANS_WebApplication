package mk.ukim.finki.diansprototype.service.implementation;

import mk.ukim.finki.diansprototype.model.Pharmacy;
import mk.ukim.finki.diansprototype.model.exceptions.PharmacyNotFoundException;
import mk.ukim.finki.diansprototype.repository.InMemoryPharmacyRepository;
import mk.ukim.finki.diansprototype.service.PharmacyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyServiceImplementation implements PharmacyService {
    private final InMemoryPharmacyRepository pharmacyRepository;

    public PharmacyServiceImplementation(InMemoryPharmacyRepository pharmacyRepository) {
        this.pharmacyRepository = pharmacyRepository;
    }

    @Override
    public List<Pharmacy> findAll() {
        return this.pharmacyRepository.findAll();
    }

    @Override
    public Pharmacy findById(Long id) throws PharmacyNotFoundException {
        Pharmacy pharmacy = pharmacyRepository.findById(id);

        if (pharmacy == null)
            throw new PharmacyNotFoundException(id);

        return pharmacy;
    }
}
