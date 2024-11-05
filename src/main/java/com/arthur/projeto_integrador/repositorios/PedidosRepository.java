package com.arthur.projeto_integrador.repositorios;

import com.arthur.projeto_integrador.models.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {}

