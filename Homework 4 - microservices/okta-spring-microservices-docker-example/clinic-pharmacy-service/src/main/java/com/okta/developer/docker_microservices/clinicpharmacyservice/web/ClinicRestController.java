package com.okta.developer.docker_microservices.clinicpharmacyservice.web;

import com.okta.developer.docker_microservices.clinicpharmacyservice.entity.Clinic;
import com.okta.developer.docker_microservices.clinicpharmacyservice.service.ClinicService;
import com.okta.developer.docker_microservices.clinicpharmacyservice.utility.ClinicType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clinics")
@CrossOrigin(origins = "http://localhost:4200")
public class ClinicRestController {
    private final ClinicService clinicService;

    public ClinicRestController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    //Detailed information for only 1 clinic, specified by the 'id' attribute;
    @GetMapping("/{id}")
    public Clinic getClinicDetailsPage(@PathVariable Integer id) {
        if (this.clinicService.findById(id).isPresent()) {
            return this.clinicService.findById(id).get();
        }
        return null;
    }

    //List of all existing clinics from the database, according to the 'type' attribute (PUBLIC or PRIVATE);
    @GetMapping("/type/{type}")
    public List<Clinic> getClinicsByType(@PathVariable String type) {
        ClinicType clinicType = ClinicType.valueOf(type);

        return clinicService.findClinicsByType(clinicType);
    }
}
