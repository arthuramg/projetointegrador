package com.arthur.projeto_integrador.repositorios;

import com.arthur.projeto_integrador.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//configuração com o banco de dados

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
