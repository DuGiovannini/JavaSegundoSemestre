package br.com.mottu.challenge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("titulo", "Gestão Inteligente de Frotas - Mottu");
        return "home"; // busca em src/main/resources/templates/home.html
    }
}

