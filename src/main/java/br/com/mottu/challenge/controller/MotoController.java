package br.com.mottu.challenge.controller;

import br.com.mottu.challenge.domain.Moto;
import br.com.mottu.challenge.domain.Patio;
import br.com.mottu.challenge.repository.MotoRepository;
import br.com.mottu.challenge.repository.PatioRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/motos")
public class MotoController {

    private final MotoRepository motoRepository;
    private final PatioRepository patioRepository;

    public MotoController(MotoRepository motoRepository, PatioRepository patioRepository) {
        this.motoRepository = motoRepository;
        this.patioRepository = patioRepository;
    }

    // Listar todas as motos
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("motos", motoRepository.findAll());
        return "moto/list";
    }

    // Formulário para nova moto
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("moto", new Moto());
        model.addAttribute("patios", patioRepository.findAll());
        return "moto/form";
    }

    // Salvar moto
    @PostMapping
    public String salvar(@Valid Moto moto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("patios", patioRepository.findAll());
            return "moto/form";
    }

    // Resolve o pátio pelo ID
    Patio patio = patioRepository.findById(moto.getPatio().getIdPatio())
            .orElseThrow(() -> new IllegalArgumentException("Pátio inválido"));
    moto.setPatio(patio);

    motoRepository.save(moto);
    return "redirect:/motos";
}

    // Editar moto
    @GetMapping("/{id}/editar")
    public String editar(@PathVariable Long id, Model model) {
        Moto moto = motoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Moto inválida: " + id));
        model.addAttribute("moto", moto);
        model.addAttribute("patios", patioRepository.findAll());
        return "moto/form";
    }

    // Excluir moto
    @GetMapping("/{id}/excluir")
    public String excluir(@PathVariable Long id) {
        motoRepository.deleteById(id);
        return "redirect:/motos";
    }
}
