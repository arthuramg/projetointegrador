package com.arthur.projeto_integrador.repositorios;

import com.arthur.projeto_integrador.models.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendasRepository extends JpaRepository<Vendas, Long> {

}
