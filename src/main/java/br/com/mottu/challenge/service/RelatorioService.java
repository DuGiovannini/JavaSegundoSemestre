package br.com.mottu.challenge.service;

import br.com.mottu.challenge.domain.Patio;
import br.com.mottu.challenge.dto.PatioOcupacaoDTO;
import br.com.mottu.challenge.repository.MotoRepository;
import br.com.mottu.challenge.repository.PatioRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelatorioService {

    private final PatioRepository patioRepository;
    private final MotoRepository motoRepository;

    public RelatorioService(PatioRepository patioRepository, MotoRepository motoRepository) {
        this.patioRepository = patioRepository;
        this.motoRepository = motoRepository;
    }

    public List<PatioOcupacaoDTO> gerarRelatorioOcupacao() {
        // 1. Busca todos os pátios do banco
        List<Patio> patios = patioRepository.findAll();
        
        // 2. Cria uma lista vazia para guardar os dados do relatório
        List<PatioOcupacaoDTO> relatorio = new ArrayList<>();

        // 3. Para cada pátio encontrado...
        for (Patio patio : patios) {
            // ...conta quantas motos estão associadas a ele
            long motosAtuais = motoRepository.countByPatioIdPatio(patio.getIdPatio());
            
            // ...cria o DTO com os dados do pátio e a contagem de motos
            PatioOcupacaoDTO dto = new PatioOcupacaoDTO(
                patio.getLocalizacao(),
                patio.getCapacidade(),
                motosAtuais
            );
            
            // ...adiciona o DTO na lista do relatório
            relatorio.add(dto);
        }

        return relatorio;
    }
}