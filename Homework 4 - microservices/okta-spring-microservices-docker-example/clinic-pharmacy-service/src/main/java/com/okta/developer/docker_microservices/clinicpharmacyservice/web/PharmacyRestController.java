package com.okta.developer.docker_microservices.clinicpharmacyservice.web;

import com.okta.developer.docker_microservices.clinicpharmacyservice.entity.Pharmacy;
import com.okta.developer.docker_microservices.clinicpharmacyservice.service.PharmacyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pharmacies")
@CrossOrigin(origins = "http://localhost:4200")
public class PharmacyRestController {
    private final PharmacyService pharmacyService;

    public PharmacyRestController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    //List of all existing pharmacies from the database;
    @GetMapping("/all")
    public List<Pharmacy> getPharmaciesPage() {
        return this.pharmacyService.findAllPharmacies();
    }

    //Detailed information for only 1 pharmacy, specified by the 'id' attribute;
    @GetMapping("/{id}")
    public Pharmacy getPharmacyDetailsPage(@PathVariable Integer id) {
        if (this.pharmacyService.findById(id).isPresent()) {
            return this.pharmacyService.findById(id).get();
        }
        return null;
    }
}
