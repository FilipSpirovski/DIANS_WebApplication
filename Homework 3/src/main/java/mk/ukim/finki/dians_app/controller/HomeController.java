package mk.ukim.finki.dians_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String getHomePage(Model model) {
        model.addAttribute("bodyContent", "home-page");
        return "master-template";
    }

    @GetMapping("/choose-category")
    public String getCategoriesPage(Model model) {
        model.addAttribute("bodyContent", "category-page");
        return "master-template";
    }

    @GetMapping("/clinics-type")
    public String getClinicsTypePage(Model model) {
        model.addAttribute("bodyContent", "clinics-type");
        return "master-template";
    }

    @GetMapping("/about-us")
    public String getAboutUsPage(Model model) {
        model.addAttribute("bodyContent", "about-us");
        return "master-template";
    }
}
