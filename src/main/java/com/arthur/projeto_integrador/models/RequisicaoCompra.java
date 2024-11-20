package com.arthur.projeto_integrador.models;

import jakarta.persistence.*;

@Entity
@Table(name = "requisicao_compra")
public class RequisicaoCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;

    private float quantidade;
    private float valorUn;
    private float valorTotal;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private StatusRequisicao status;

    public RequisicaoCompra(Produto produto, float quantidade, float valorUn, float valorTotal, StatusRequisicao status) {
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUn = valorUn;
        this.valorTotal = valorTotal;
        this.status = status;
    }

    public RequisicaoCompra() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public StatusRequisicao getStatus() {
        return status;
    }

    public void setStatus(StatusRequisicao status) {
        this.status = status;
    }
}


