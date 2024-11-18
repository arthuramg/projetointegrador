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
@CrossOrigin(origins = "*") //permite qualquer rota acessar
public class produtoController {
    @Autowired
    private ProdutoRepository repository;
    private ProdutoService ps;

    @GetMapping("/listarProdutos")
    public List<ProdutoDTO> obterProduto() {
        return null;
    }

    private void produto() {
    }

    @PostMapping("/cadastrarProduto")
    public ResponseEntity<?> cadastrarProduto(@RequestBody Produto produto){
        return ps.cadastrarProduto(produto, "cadastrar");
    }

}
