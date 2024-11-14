package com.arthur.projeto_integrador.models;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
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
