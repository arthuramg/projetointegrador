package com.arthur.projeto_integrador.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "produtos")

public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeProduto;
    private Integer quantidade;
    private int estoqueMin;
    private int estoqueMax;
    private Double precoProduto;
    private String tipoProduto;

    public String getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

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

    public Double setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
        return precoProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public Integer setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
        return quantidade;
    }

    public int getEstoqueMin() {
        return estoqueMin;
    }

    public void setEstoqueMin(int estoqueMin) {
        this.estoqueMin = estoqueMin;
    }

    public int getEstoqueMax() {
        return estoqueMax;
    }

    public void setEstoqueMax(int estoqueMax) {
        this.estoqueMax = estoqueMax;
    }
}
