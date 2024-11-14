package com.arthur.projeto_integrador.models;

import java.io.Serializable;
import java.util.Objects;

public class VendasProdutoPK implements Serializable {

    private Long idVenda;
    private Long idProduto;

    public VendasProdutoPK() {}

    public VendasProdutoPK(Long idVenda, Long idProduto) {
        this.idVenda = idVenda;
        this.idProduto = idProduto;
    }

    public Long getIdVenda() { return idVenda; }
    public void setIdVenda(Long idVenda) { this.idVenda = idVenda; }

    public Long getIdProduto() { return idProduto; }
    public void setIdProduto(Long idProduto) { this.idProduto = idProduto; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VendasProdutoPK that = (VendasProdutoPK) o;
        return Objects.equals(idVenda, that.idVenda) && Objects.equals(idProduto, that.idProduto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVenda, idProduto);
    }
}
