package br.com.mottu.challenge.controller;

import br.com.mottu.challenge.domain.Patio;
import br.com.mottu.challenge.repository.PatioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/patios")
public class PatioController {

    private final PatioRepository patioRepository;

    public PatioController(PatioRepository patioRepository) {
        this.patioRepository = patioRepository;
    }

    // Listar todos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("patios", patioRepository.findAll());
        return "patio/list";
    }

    // Form de novo pátio
    @GetMapping("/novo")
    public String novo(Patio patio) {
        return "patio/form";
    }

    // Salvar pátio
    @PostMapping
    public String salvar(@Valid Patio patio, BindingResult result) {
        if (result.hasErrors()) {
            return "patio/form";
        }
        patioRepository.save(patio);
        return "redirect:/patios";
    }

    // Editar pátio
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        Patio patio = patioRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Pátio inválido: " + id));
        model.addAttribute("patio", patio);
        return "patio/form";
    }

    // Excluir pátio
    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        patioRepository.deleteById(id);
        return "redirect:/patios";
    }
}
