package mk.ukim.finki.diansprototype.service;

import mk.ukim.finki.diansprototype.model.Pharmacy;
import mk.ukim.finki.diansprototype.model.exceptions.PharmacyNotFoundException;

import java.util.List;

public interface PharmacyService {

    List<Pharmacy> findAll();

    Pharmacy findById(Long id) throws PharmacyNotFoundException;
}
