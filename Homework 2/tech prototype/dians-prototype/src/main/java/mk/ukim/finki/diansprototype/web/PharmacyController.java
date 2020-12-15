package mk.ukim.finki.diansprototype.web;

import mk.ukim.finki.diansprototype.model.HealthInstitution;
import mk.ukim.finki.diansprototype.model.Pharmacy;
import mk.ukim.finki.diansprototype.model.exceptions.PharmacyNotFoundException;
import mk.ukim.finki.diansprototype.service.PharmacyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
            model.addAttribute("errorOccurred", true);
            model.addAttribute("error", error);
        }
        List<Pharmacy> pharmacies = this.pharmacyService.findAll();
        model.addAttribute("pharmacies", pharmacies);

        return "pharmacies-page";
    }

    @GetMapping("/info")
    public String getPharmacyInfo(@RequestParam Long id, Model model) {
        try {
            Pharmacy pharmacy = this.pharmacyService.findById(id);
            model.addAttribute("pharmacy", pharmacy);

            return "pharmacy-info";
        } catch (PharmacyNotFoundException e) {
            return String.format("redirect:/pharmacies?error=%s", e.getMessage());
        }
    }
}
