package com.arthur.projeto_integrador.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ClienteResource {

    @JsonProperty("nome_cliente")
    private String nome;
    @JsonProperty("id_cliente")
    private Long id;

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

    public ClienteResource(String nome, Long id) {
        this.nome = nome;
        this.id = id;
    }
}
