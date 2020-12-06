package mk.ukim.finki.diansprototype.web;

import mk.ukim.finki.diansprototype.model.HealthInstitution;
import mk.ukim.finki.diansprototype.model.enums.HealthInstitutionType;
import mk.ukim.finki.diansprototype.model.exceptions.HealthInstitutionNotFoundException;
import mk.ukim.finki.diansprototype.service.HealthInstitutionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/health-institutions")
public class HealthInstitutionController {
    private final HealthInstitutionService healthInstitutionService;

    public HealthInstitutionController(HealthInstitutionService healthInstitutionService) {
        this.healthInstitutionService = healthInstitutionService;
    }

    @GetMapping
    public String getHealthInstitutionsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("errorOccurred", true);
            model.addAttribute("error", error);
        }
        List<HealthInstitution> institutions = this.healthInstitutionService.findAll();
        model.addAttribute("institutions", institutions);

        return "health-institutions-page";
    }

    @GetMapping("/choose-type")
    public String getFromChosenCategory() {
        return "health-institutions-types";
    }

    @GetMapping("/chosen-type")
    public String getHealthInstitutionsByType(@RequestParam String type, Model model) {
        HealthInstitutionType institutionType = HealthInstitutionType.valueOf(type);
        List<HealthInstitution> institutions = this.healthInstitutionService.findByType(institutionType);
        model.addAttribute("institutions", institutions);

        if (institutionType.equals(HealthInstitutionType.PUBLIC))
            return "public-health-institutions-page";
        else
            return "private-health-institutions-page";
    }

    @GetMapping("/info")
    public String getHealthInstitutionInfo(@RequestParam Long id, Model model) {
        try {
            HealthInstitution institution = this.healthInstitutionService.findById(id);
            model.addAttribute("institution", institution);

            if (institution.getType().equals(HealthInstitutionType.PUBLIC))
                return "public-health-institution-info";
            else
                return "private-health-institution-info";
        } catch (HealthInstitutionNotFoundException e) {
            return String.format("redirect:/health-institutions?error=%s", e.getMessage());
        }
    }
}
