package com.arthur.projeto_integrador.controllers;


import com.arthur.projeto_integrador.dto.ProdutoDTO;
import com.arthur.projeto_integrador.models.Produto;
import com.arthur.projeto_integrador.repositorios.ProdutoRepository;
import com.arthur.projeto_integrador.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos") // Corrigido o caminho
public class ProdutoController {

    @Autowired
    private ProdutoRepository repository;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<ProdutoDTO> obterProduto() {
        // Implementação correta para retornar a lista de produtos
        return repository.findAll().stream()
                .map(produto -> new ProdutoDTO(produto))
                .toList();
    }

    @GetMapping("/{id}") // Alterado para um caminho mais simples
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        Produto novoProduto = produtoService.cadastrarProduto(produto);
        return ResponseEntity.status(201).body(novoProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {
        try {
            Produto produto = produtoService.atualizarProduto(id, produtoAtualizado);
            return ResponseEntity.ok(produto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
