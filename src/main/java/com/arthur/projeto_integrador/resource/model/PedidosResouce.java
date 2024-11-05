package com.arthur.projeto_integrador.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PedidosResouce {

    @JsonProperty("id_pedido")
    private long idPedido;

    @JsonProperty("id_requisicao")
    private long idRequisicao;

    public long getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(long idPedido) {
        this.idPedido = idPedido;
    }

    public long getIdRequisicao() {
        return idRequisicao;
    }

    public void setIdRequisicao(long idRequisicao) {
        this.idRequisicao = idRequisicao;
    }

    public PedidosResouce(long idRequisicao, long idPedido) {
        this.idRequisicao = idRequisicao;
        this.idPedido = idPedido;
    }
}
