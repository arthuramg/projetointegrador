package com.arthur.projeto_integrador.repositorios;

import com.arthur.projeto_integrador.models.Pedidos;
import com.arthur.projeto_integrador.models.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PedidosRepository extends JpaRepository<Pedidos, Long> {

    // Buscar pedidos de um fornecedor específico (usando o id)
    List<Pedidos> findByFornecedorId(Long fornecedorId);

    // Buscar pedidos por status
    @Query("SELECT p FROM Pedidos p WHERE p.status = :status")
    List<Pedidos> findByStatus(@Param("status") StatusPedido status);

    // Buscar pedidos criados nos últimos 30 dias
    @Query("SELECT p FROM Pedidos p WHERE p.data >= :dataLimite")
    List<Pedidos> findRecentesUltimos30Dias(@Param("dataLimite") LocalDate dataLimite);
}
