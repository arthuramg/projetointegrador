package com.arthur.projeto_integrador.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendas_produtos")
@IdClass(VendasProdutoPK.class)
public class VendasProduto {

    @Id
    private Long idVenda;

    @Id
    private Long idProduto;

    private int quantidade;

    public VendasProduto(Long idVenda, Long idProduto, int quantidade) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public Long getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Long idVenda) {
        this.idVenda = idVenda;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
