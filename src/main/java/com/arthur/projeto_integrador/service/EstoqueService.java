package com.arthur.projeto_integrador.service;

import com.arthur.projeto_integrador.models.Estoque;
import com.arthur.projeto_integrador.repositorios.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstoqueService {

    @Autowired
    private EstoqueRepository estoqueRepository;

    public Iterable<Estoque> listarTodosItens() {
        return estoqueRepository.findAll();
    }

    public Estoque atualizarEstoque(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }
}
