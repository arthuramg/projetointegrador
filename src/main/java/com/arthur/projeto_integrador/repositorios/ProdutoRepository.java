package com.arthur.projeto_integrador.repositorios;

import com.arthur.projeto_integrador.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
