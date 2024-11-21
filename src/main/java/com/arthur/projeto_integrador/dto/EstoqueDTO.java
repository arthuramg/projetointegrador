package com.arthur.projeto_integrador.dto;

import com.arthur.projeto_integrador.models.Estoque;
import com.arthur.projeto_integrador.models.Produto;

public class EstoqueDTO {

    private Long id;
    private String nomeProduto;
    private String marca;
    private float quantidade;
    private float valorUnitario;
    private float valorTotalEstoque;

    // Construtor que aceita a entidade Estoque
    public EstoqueDTO(Estoque estoque) {
        this.id = estoque.getId();
        this.nomeProduto = estoque.getNomeProduto();
        this.marca = estoque.getMarca();
        this.quantidade = estoque.getQuantidade();
        this.valorUnitario = estoque.getValorUn();
        this.valorTotalEstoque = estoque.getValorEstoque();
    }

    // Getters e Setters
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public float getValorTotalEstoque() {
        return valorTotalEstoque;
    }

    public void setValorTotalEstoque(float valorTotalEstoque) {
        this.valorTotalEstoque = valorTotalEstoque;
    }
}