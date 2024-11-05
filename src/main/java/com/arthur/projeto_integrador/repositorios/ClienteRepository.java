package com.arthur.projeto_integrador.repositorios;

import com.arthur.projeto_integrador.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

//configuração com o banco de dados

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
