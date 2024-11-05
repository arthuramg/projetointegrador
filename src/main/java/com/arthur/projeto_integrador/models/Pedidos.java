package com.arthur.projeto_integrador.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Pedidos {

    @Id
    private long idPedido;
    private long idRequisicao;

    public Pedidos(long idPedido, long idRequisicao) {
        this.idPedido = idPedido;
        this.idRequisicao = idRequisicao;
    }

    public Long getIdPedidos(){
        return idPedido;
    }
    public void setIdPedido(Long idPedido) { this.idPedido = idPedido; }
    public long getIdRequisicao () { return idRequisicao; }
    public void setIdRequisicao ( Long idRequisicao) { this.idRequisicao = idRequisicao; }
}
