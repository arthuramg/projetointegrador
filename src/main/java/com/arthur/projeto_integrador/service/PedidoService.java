package com.arthur.projeto_integrador.service;

import com.arthur.projeto_integrador.models.Pedidos;
import com.arthur.projeto_integrador.models.Pedidos;
import com.arthur.projeto_integrador.models.Produto;
import com.arthur.projeto_integrador.repositorios.FornecedorRepository;
import com.arthur.projeto_integrador.repositorios.PedidosRepository;
import com.arthur.projeto_integrador.repositorios.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PedidoService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    @Autowired
    private PedidosRepository pedidosRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public Iterable<Pedidos> listarPedidos() {
        return pedidosRepository.findAll();
    }

    public ResponseEntity<?> registrarPedido(Pedidos pedido) {
        // Validação básica antes de salvar
        if (pedido.getQtdItens() <= 0) {
            return ResponseEntity.badRequest().body("A quantidade de itens deve ser maior que zero.");
        }

        if (pedido.getIdFornecedor() == null || !validarFornecedor(pedido.getIdFornecedor())) {
            return ResponseEntity.badRequest().body("Fornecedor inválido.");
        }

        Pedidos pedidoSalvo = pedidosRepository.save(pedido);
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoSalvo);
    }

    public ResponseEntity<?> buscarPorId(Long id) {
        Optional<Pedidos> pedido = pedidosRepository.findById(id);

        if (pedido.isPresent()) {
            return ResponseEntity.ok(pedido.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado.");
        }
    }


    public Iterable<Pedidos> listarPedidosPorFornecedor(Long idFornecedor) {
        return pedidosRepository.findByFornecedorId(idFornecedor);
    }


    private boolean validarFornecedor(Long idFornecedor) {
        return fornecedorRepository.existsById(idFornecedor);
    }
}
