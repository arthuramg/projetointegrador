package com.arthur.projeto_integrador.repositorios;

import com.arthur.projeto_integrador.models.Estoque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstoqueRepository extends JpaRepository<Estoque, Long> {



}
