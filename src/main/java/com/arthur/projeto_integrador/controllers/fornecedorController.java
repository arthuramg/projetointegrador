package com.arthur.projeto_integrador.controllers;

import com.arthur.projeto_integrador.models.Fornecedor;
import com.arthur.projeto_integrador.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fornecedores")
public class fornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public ResponseEntity<List<Fornecedor>> listarTodos(){
        List<Fornecedor> fornecedores = fornecedorService.listarTodos();
        return ResponseEntity.ok(fornecedores);
    }

    @GetMapping("{id}")
    public ResponseEntity<Fornecedor> buscarPorId(@PathVariable Long idFornecedor){
        return fornecedorService.buscarPorId(idFornecedor)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Fornecedor> salvarFornecedor(@RequestBody Fornecedor fornecedor){
        Fornecedor novoFornecedor = fornecedorService.salvarFonecedor(fornecedor);
        return ResponseEntity.status(201).body(novoFornecedor);
    }

    @PutMapping("{id}")
    public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable Long idFornecedor, @RequestBody Fornecedor fornecedorAtualizado) {
        try {
            Fornecedor fornecedor = fornecedorService.alterarFornecedor(idFornecedor, fornecedorAtualizado);
            return ResponseEntity.ok(fornecedor);
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirFornecedor(@PathVariable Long idFornecedor){
        try{
            fornecedorService.excluirFornecedor(idFornecedor);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
