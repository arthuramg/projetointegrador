package com.arthur.projeto_integrador.service;

import com.arthur.projeto_integrador.models.Pedidos;
import com.arthur.projeto_integrador.models.Produto;
import com.arthur.projeto_integrador.repositorios.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Pedidos registrarCompra(Pedidos pedido) {
        return ProdutoRepository.save(pedido);
    }

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void excluir(Long id) {
        produtoRepository.deleteById(id);
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        Produto produtoExistente = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado")); //caso não encontre o produto, retorna o erro

        produtoExistente.setNomeProduto(produtoAtualizado.getNomeProduto());
        produtoExistente.setQuantidade(produtoAtualizado.getQuantidade());
        produtoExistente.setPrecoProduto(produtoAtualizado.getPrecoProduto());

        return produtoRepository.save(produtoExistente);
    }
}
