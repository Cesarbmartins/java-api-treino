package com.treino.spring.applegal.DTO;

public class ObraDTO {

    private Long id;
    private String nome;
    private String sinopse;
    private Integer qtd_episodios;
    private Double media_avaliacao;
    private String data_lancamento;
    private String tipo;

    public ObraDTO() {
    }

    public ObraDTO(Long id, String nome, String sinopse, Integer qtd_episodios, Double media_avaliacao, String data_lancamento, String tipo) {
        this.id = id;
        this.nome = nome;
        this.sinopse = sinopse;
        this.qtd_episodios = qtd_episodios;
        this.media_avaliacao = media_avaliacao;
        this.data_lancamento = data_lancamento;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Integer getQtd_episodios() {
        return qtd_episodios;
    }

    public void setQtd_episodios(Integer qtd_episodios) {
        this.qtd_episodios = qtd_episodios;
    }

    public Double getMedia_avaliacao() {
        return media_avaliacao;
    }

    public void setMedia_avaliacao(Double media_avaliacao) {
        this.media_avaliacao = media_avaliacao;
    }

    public String getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(String data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}