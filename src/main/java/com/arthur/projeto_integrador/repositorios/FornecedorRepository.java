package com.arthur.projeto_integrador.repositorios;

import com.arthur.projeto_integrador.models.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Long> {}