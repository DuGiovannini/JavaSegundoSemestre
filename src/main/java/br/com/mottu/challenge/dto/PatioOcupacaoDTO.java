package br.com.mottu.challenge.dto;

public class PatioOcupacaoDTO {

    private String localizacao;
    private int capacidade;
    private long motosAtuais;

    // Construtor
    public PatioOcupacaoDTO(String localizacao, int capacidade, long motosAtuais) {
        this.localizacao = localizacao;
        this.capacidade = capacidade;
        this.motosAtuais = motosAtuais;
    }

    // Getters e Setters
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

    public long getMotosAtuais() {
        return motosAtuais;
    }

    public void setMotosAtuais(long motosAtuais) {
        this.motosAtuais = motosAtuais;
    }
}