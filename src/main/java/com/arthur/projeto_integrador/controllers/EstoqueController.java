package com.arthur.projeto_integrador.controllers;

import com.arthur.projeto_integrador.dto.EstoqueDTO;
import com.arthur.projeto_integrador.dto.ProdutoDTO;
import com.arthur.projeto_integrador.models.Produto;
import com.arthur.projeto_integrador.repositorios.EstoqueRepository;
import com.arthur.projeto_integrador.service.EstoqueService;
import com.arthur.projeto_integrador.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    @Autowired
    private EstoqueService estoqueService;

    // Listar todos os produtos no estoque
    @GetMapping
    public List<EstoqueDTO> listarEstoque() {
        return estoqueService.listarTodosItens().stream()
                .map(EstoqueDTO::new) // Converte Estoque para EstoqueDTO
                .collect(Collectors.toList());
    }

    // Buscar um produto no estoque por ID
    @GetMapping("/{id}")
    public ResponseEntity<EstoqueDTO> buscarProdutoNoEstoque(@PathVariable Long id) {
        return estoqueService.buscarPorId(id)
                .map(estoque -> ResponseEntity.ok(new EstoqueDTO(estoque))) // Converte para EstoqueDTO
                .orElse(ResponseEntity.notFound().build());
    }
}