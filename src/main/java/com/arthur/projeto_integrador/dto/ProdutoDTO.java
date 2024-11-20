package com.arthur.projeto_integrador.dto;

import com.arthur.projeto_integrador.models.Produto;

public class ProdutoDTO {

    private String nome;
    private Integer quantidade;
    private Double preco;

    // Construtor que aceita um objeto Produto
    public ProdutoDTO(Produto produto) {
        this.nome = produto.getNomeProduto();
        this.quantidade = produto.getQuantidade();
        this.preco = produto.getPrecoProduto();
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
