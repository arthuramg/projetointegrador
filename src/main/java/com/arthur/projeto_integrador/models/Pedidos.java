package com.arthur.projeto_integrador.models;

import jakarta.persistence.*;

import java.time.LocalDate;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int qtdItens;

    @Column(nullable = false)
    private float valorTotal;

    @Column(nullable = false)
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusPedido status;

    @ManyToOne
    @JoinColumn(name = "id_fornecedor", nullable = false)
    private Fornecedor fornecedor;

    // Construtores
    public Pedidos() {
    }

    public Pedidos(int qtdItens, float valorTotal, LocalDate data, StatusPedido status, Fornecedor fornecedor) {
        this.qtdItens = qtdItens;
        this.valorTotal = valorTotal;
        this.data = data;
        this.status = status;
        this.fornecedor = fornecedor;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(int qtdItens) {
        this.qtdItens = qtdItens;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public Long getIdFornecedor() {
        if (fornecedor != null) {
            return fornecedor.getIdFornecedor();
        }
        return null;
    }
}

