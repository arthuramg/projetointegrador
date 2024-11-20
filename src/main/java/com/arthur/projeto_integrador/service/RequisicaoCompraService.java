package com.arthur.projeto_integrador.service;

import com.arthur.projeto_integrador.models.RequisicaoCompra;
import com.arthur.projeto_integrador.repositorios.RequisicaoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RequisicaoCompraService {

    @Autowired
    private RequisicaoRepository requisicaoRepository;

    public Iterable<RequisicaoCompra> listarRequisicoes() {
        return requisicaoRepository.findAll();
    }

    public RequisicaoCompra registrarRequisicao(RequisicaoCompra requisicao) {
        return requisicaoRepository.save(requisicao);
    }

    public RequisicaoCompra buscarPorId(Long id) {
        return requisicaoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Requisição não encontrada com o ID: " + id));
    }
}
