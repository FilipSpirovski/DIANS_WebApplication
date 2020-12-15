package mk.ukim.finki.dians_app.controller;

import mk.ukim.finki.dians_app.model.Pharmacy;
import mk.ukim.finki.dians_app.service.PharmacyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/pharmacies")
public class PharmacyController {
    private final PharmacyService pharmacyService;

    public PharmacyController(PharmacyService pharmacyService) {
        this.pharmacyService = pharmacyService;
    }

    @GetMapping
    public String getPharmaciesPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Pharmacy> pharmacies = this.pharmacyService.findAllPharmacies();
        model.addAttribute("pharmacies", pharmacies);
        model.addAttribute("bodyContent", "pharmacies");
        return "master-template";
    }

    @GetMapping("/{id}")
    public String getPharmacyDetailsPage(@PathVariable Integer id, Model model) {
        if (this.pharmacyService.findById(id).isPresent()) {
            Pharmacy pharmacy = this.pharmacyService.findById(id).get();
            model.addAttribute("pharmacy", pharmacy);
            model.addAttribute("bodyContent", "pharmacy-details");
            return "master-template";
        }
        return "redirect:/pharmacies?error=PharmacyNotFound";
    }
}

