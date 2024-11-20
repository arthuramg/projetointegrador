package com.arthur.projeto_integrador.service;

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

    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto cadastrarProduto(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
        Optional<Produto> produtoExistente = produtoRepository.findById(id);

        if(produtoExistente.isPresent()) {
            Produto produto = produtoExistente.get();
            produto.setPrecoProduto(produtoAtualizado.getPrecoProduto());
            produto.setNomeProduto(produtoAtualizado.getNomeProduto());
            produto.setTipoProduto(produtoAtualizado.getTipoProduto());
            produto.setQuantidade(produtoAtualizado.getQuantidade());
            return produtoRepository.save(produto);
        }
        throw new RuntimeException("Produto não encontrado");
    }
}
