package com.arthur.projeto_integrador.models;

import jakarta.persistence.*;

@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getPrecoProduto() {
        return precoProduto;
    }

    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Produto(Long id, String nomeProduto, Double precoProduto, Integer quantidade) {
        this.id = id;
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidade = quantidade;
    }

    @Column(nullable = false)
    private String nomeProduto;
    private Integer quantidade;
    private Double precoProduto;
}
