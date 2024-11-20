package com.arthur.projeto_integrador.service;


import com.arthur.projeto_integrador.models.Fornecedor;
import com.arthur.projeto_integrador.repositorios.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public List<Fornecedor> listarTodos(){
        return fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarPorId(Long idFornecedor){
        return fornecedorRepository.findById(idFornecedor);
    }

    public Fornecedor salvarFonecedor(Fornecedor fornecedor){
        return fornecedorRepository.save(fornecedor);
    }

    public Fornecedor alterarFornecedor(Long idFornecedor, Fornecedor fornecedorAtualizado){
        Optional<Fornecedor> fornecedorExistente = fornecedorRepository.findById(idFornecedor);

        if (fornecedorExistente.isPresent()) {
            Fornecedor fornecedor = fornecedorExistente.get();
            fornecedor.setRazaoSocial(fornecedorAtualizado.getRazaoSocial());
            fornecedor.setCnpj(fornecedorAtualizado.getCnpj());
            fornecedor.setEndereco(fornecedorAtualizado.getEndereco());
            fornecedor.setTelefone(fornecedorAtualizado.getTelefone());
            fornecedor.setEmail(fornecedorAtualizado.getEmail());
            return fornecedorRepository.save(fornecedor);
        }
        throw new RuntimeException("Fornecedor não encontrado.");
    }

    public void excluirFornecedor(Long idFornecedor) {
        if (fornecedorRepository.existsById(idFornecedor)) {
            fornecedorRepository.deleteById(idFornecedor);
        } else {
            throw new RuntimeException("Fornecedor não encontrado.");
        }
    }
}
