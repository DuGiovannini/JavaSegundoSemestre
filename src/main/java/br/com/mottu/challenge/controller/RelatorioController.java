package br.com.mottu.challenge.controller;

import br.com.mottu.challenge.dto.PatioOcupacaoDTO;
import br.com.mottu.challenge.service.RelatorioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/relatorios")
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioService) {
        this.relatorioService = relatorioService;
    }

    @GetMapping("/ocupacao")
    public String mostrarRelatorioOcupacao(Model model) {
        List<PatioOcupacaoDTO> relatorio = relatorioService.gerarRelatorioOcupacao();
        model.addAttribute("relatorio", relatorio);
        return "relatorio/ocupacao"; // Nome do arquivo HTML
    }
}