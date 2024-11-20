package com.arthur.projeto_integrador.repositorios;

import com.arthur.projeto_integrador.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {

    //buscar fornecedor pelo nome (Razão Social)
    List<Fornecedor> findByRazaoSocialContainingIgnoreCase(String razaoSocial);

}