package com.arthur.projeto_integrador.service;

import com.arthur.projeto_integrador.models.Pedidos;
import com.arthur.projeto_integrador.models.Produto;
import com.arthur.projeto_integrador.repositorios.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private Produto produto;

    public Iterable<Pedidos>  listarPedidos(){
        return pedidosRepository.findAll();
    }

    public Pedidos registrarPedidos(Pedidos pedido) {
        return pedidosRepository.save(pedido);
    }

    public Optional<Pedidos> buscarPorId(Long id) {
        return pedidosRepository.findById(id);
    }
}
