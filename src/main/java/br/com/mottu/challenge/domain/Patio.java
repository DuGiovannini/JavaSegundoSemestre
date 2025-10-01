package br.com.mottu.challenge.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "patio")
public class Patio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // gera automaticamente
    @Column(name = "id_patio")
    private Long idPatio; // ✅ Nome claro e consistente

    @NotBlank(message = "A localização não pode ser vazia")
    @Column(nullable = false, length = 100)
    private String localizacao;

    @Min(value = 1, message = "A capacidade deve ser pelo menos 1")
    @Column(nullable = false)
    private int capacidade;

    // Getters e Setters
    public Long getIdPatio() {
        return idPatio;
    }

    public void setIdPatio(Long idPatio) {
        this.idPatio = idPatio;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }
}
