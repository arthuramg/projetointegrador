package com.arthur.projeto_integrador.controllers;

import com.arthur.projeto_integrador.models.Vendas;
import com.arthur.projeto_integrador.service.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendas")
public class vendasController {
    @Autowired
    private VendasService vendasService;

    @GetMapping
    public ResponseEntity<List<Vendas>> listarTodas() {
        List<Vendas> vendas = vendasService.listarTodas();
        return ResponseEntity.ok(vendas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vendas> buscarPorId(@PathVariable Long id) {
        return vendasService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Vendas> salvarVenda(@RequestBody Vendas venda) {
        Vendas novaVenda = vendasService.salvarVenda(venda);
        return ResponseEntity.status(201).body(novaVenda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vendas> atualizarVenda(@PathVariable Long id, @RequestBody Vendas vendaAtualizada) {
        try {
            Vendas venda = vendasService.atualizarVenda(id, vendaAtualizada);
            return ResponseEntity.ok(venda);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirVenda(@PathVariable Long id) {
        try {
            vendasService.excluirVenda(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}

