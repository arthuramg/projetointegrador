package com.arthur.projeto_integrador.repositorios;

import com.arthur.projeto_integrador.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//configuração com o banco de dados

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    //buscar clientes dentro de uma faixa etária
    @Query("SELECT c FROM Cliente c WHERE c.idade BETWEEN :idadeMin AND :idadeMax")
    List<Cliente> findByIdadeBetween(@Param("idadeMin") int idadeMin, @Param("idadeMax") int idadeMax);

    //buscar clientes por nome
    List<Cliente> findByNomeContainingIgnoreCase(String nome);

}
