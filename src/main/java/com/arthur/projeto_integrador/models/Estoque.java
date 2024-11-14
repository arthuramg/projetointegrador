package com.arthur.projeto_integrador.models;

import jakarta.persistence.*;

@Entity
@Table(name = "estoque")
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_produto", nullable = false)
    private String nomeProduto;

    @ManyToOne
    @JoinColumn(name = "id_categoria", nullable = false)
    private Categoria categoria;

    private String marca;
    private float quantidade;
    private float valorUn;
    private float valorEstoque;

    public Estoque(String nomeProduto, Categoria categoria, String marca, float quantidade, float valorUn, float valorEstoque) {
        this.nomeProduto = nomeProduto;
        this.categoria = categoria;
        this.marca = marca;
        this.quantidade = quantidade;
        this.valorUn = valorUn;
        this.valorEstoque = valorEstoque;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
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

    public float getValorUn() {
        return valorUn;
    }

    public void setValorUn(float valorUn) {
        this.valorUn = valorUn;
    }

    public float getValorEstoque() {
        return valorEstoque;
    }

    public void setValorEstoque(float valorEstoque) {
        this.valorEstoque = valorEstoque;
    }
}

