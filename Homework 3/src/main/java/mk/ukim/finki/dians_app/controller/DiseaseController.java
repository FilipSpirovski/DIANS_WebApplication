package mk.ukim.finki.dians_app.controller;

import mk.ukim.finki.dians_app.model.Comment;
import mk.ukim.finki.dians_app.model.Disease;
import mk.ukim.finki.dians_app.model.enums.DiseaseType;
import mk.ukim.finki.dians_app.service.DiseaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/diseases")
public class DiseaseController {
    private final DiseaseService diseaseService;

    public DiseaseController(DiseaseService diseaseService) {
        this.diseaseService = diseaseService;
    }

    @GetMapping
    public String getDiseasesPage(Model model) {
        List<Disease> diseases = this.diseaseService.findAll();
        model.addAttribute("diseases", diseases);
        model.addAttribute("bodyContent", "diseases");

        return "master-template";
    }

    @GetMapping("/type/{diseaseType}")
    public String getDiseasesByType(@PathVariable String diseaseType, Model model) {
        DiseaseType type = DiseaseType.valueOf(diseaseType);
        List<Disease> diseases = this.diseaseService.findAllByType(type);
        model.addAttribute("diseases", diseases);
        model.addAttribute("bodyContent", "diseases");

        return "master-template";
    }

    @GetMapping("/{diseaseId}")
    public String getDiseaseById(@PathVariable Long diseaseId, Model model) {
        Disease disease = this.diseaseService.findById(diseaseId);
        List<Comment> top3Comments = disease.getComments().stream()
                .sorted()
                .limit(3)
                .collect(Collectors.toList());
        model.addAttribute("disease", disease);
        model.addAttribute("top3Comments", top3Comments);
        model.addAttribute("bodyContent", "disease-details");

        return "master-template";
    }
}
