package com.arthur.projeto_integrador.controllers;

import org.springframework.http.ResponseEntity;
import com.arthur.projeto_integrador.models.Pedidos;
import com.arthur.projeto_integrador.models.Produto;
import com.arthur.projeto_integrador.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Controller
public class controllerPrincipal {
    @RestController
    @RequestMapping("/api/compras")
    public class CompraController {

        @Autowired
        private ProdutoService compraService;

        @PostMapping
        public Pedidos registrarCompra(@RequestBody Pedidos compra) {
            return compraService.registrarCompra(compra);
        }

        @GetMapping("/{id}")
        public ResponseEntity<Produto> buscarCompra(@PathVariable Long id) {
            return compraService.buscarPorId(id)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }
    }

}
