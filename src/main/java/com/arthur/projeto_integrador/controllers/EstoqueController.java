package com.arthur.projeto_integrador.controllers;

import com.arthur.projeto_integrador.models.Produto;
import com.arthur.projeto_integrador.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<Produto>> listarEstoque() {
        List<Produto>produtos = produtoService.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarProdutoNoEstoque(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}