package com.arthur.projeto_integrador.dto;

import com.arthur.projeto_integrador.models.Vendas;

import java.time.LocalDateTime;

public class VendasDTO {

    private Long id;
    private String notaFiscal;
    private LocalDateTime data;
    private float valorTotal;

    // Construtor que aceita a entidade Vendas
    public VendasDTO(Vendas venda) {
        this.id = venda.getId();
        this.notaFiscal = venda.getNotaFiscal();
        this.data = venda.getData();
        this.valorTotal = venda.getValorTotal();
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
