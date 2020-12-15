package mk.ukim.finki.dians_app.controller;

import mk.ukim.finki.dians_app.model.Clinic;
import mk.ukim.finki.dians_app.model.enums.ClinicType;
import mk.ukim.finki.dians_app.service.ClinicService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/clinics")
public class ClinicController {
    private final ClinicService clinicService;

    public ClinicController(ClinicService clinicService) {
        this.clinicService = clinicService;
    }

    @GetMapping
    public String getClinicsPage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("hasError", true);
            model.addAttribute("error", error);
        }
        List<Clinic> clinicList = this.clinicService.findAllClinics();
        model.addAttribute("clinics", clinicList);
        model.addAttribute("bodyContent", "clinics");
        return "master-template";
    }

    @GetMapping("/{id}")
    public String getClinicDetailsPage(@PathVariable Integer id, Model model) {
        if (this.clinicService.findById(id).isPresent()) {
            Clinic clinic = this.clinicService.findById(id).get();
            model.addAttribute("clinic", clinic);
            model.addAttribute("bodyContent", "clinic-details");
            return "master-template";
        }
        return "redirect:/clinics?error=ClinicNotFound";
    }

    @GetMapping("/type/{type}")
    public String getClinicsByType(@PathVariable String type, Model model) {
        ClinicType clinicType = ClinicType.valueOf(type);
        List<Clinic> clinics = clinicService.findClinicsByType(clinicType);

        model.addAttribute("clinics", clinics);
        model.addAttribute("bodyContent", "clinics");
        return "master-template";
    }
}
