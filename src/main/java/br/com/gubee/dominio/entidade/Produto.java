package br.com.gubee.dominio.entidade;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Produto {

    @JsonProperty("productName")
    private String nome;

    @JsonProperty("description")
    private String descricao;

    @JsonProperty("targetMarket")
    private List<String> mercadosAlvos;

    @JsonProperty("stack")
    private List<String> tecnologias;

    public Produto(String nome, String descricao, List<String> mercadosAlvos, List<String> tecnologias) {
        this.nome = nome;
        this.descricao = descricao;
        this.mercadosAlvos = mercadosAlvos;
        this.tecnologias = tecnologias;
    }

    public Produto() {
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public List<String> getMercadosAlvos() {
        return mercadosAlvos;
    }

    public List<String> getTecnologias() {
        return tecnologias;
    }
}