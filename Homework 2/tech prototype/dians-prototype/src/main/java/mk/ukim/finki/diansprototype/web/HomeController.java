package mk.ukim.finki.diansprototype.web;

import mk.ukim.finki.diansprototype.model.HealthInstitution;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String getHomePage(@RequestParam(required = false) String error, Model model) {
        if (error != null && !error.isEmpty()) {
            model.addAttribute("errorOccurred", true);
            model.addAttribute("error", error);
        }

        return "home-page";
    }

    @GetMapping("/about-us")
    public String getAboutUsPage() {
        return "about-us";
    }

    @GetMapping("/choose-category")
    public String getCategoriesPage() {
        return "categories";
    }

    @GetMapping("/chosen-category")
    public String getFromChosenCategory(@RequestParam String choice) {
        switch (choice) {
            case "Pharmacy":
                return "redirect:/pharmacies";
            case "Health Institution":
                return "redirect:/health-institutions/choose-type";
            default:
                return String.format("redirect:/home?error=%s", "Error 404: Page Not Found!");
        }
    }

    @GetMapping("/contact-us")
    public String getContactPage() {
        return "contact-us";
    }
}
