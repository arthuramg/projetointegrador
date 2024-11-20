package com.arthur.projeto_integrador.repositorios;
import com.arthur.projeto_integrador.models.Produto;
import com.arthur.projeto_integrador.models.RequisicaoCompra;
import com.arthur.projeto_integrador.models.StatusRequisicao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequisicaoRepository extends JpaRepository<RequisicaoCompra, Long> {

    //buscar reqisicao de compra por produtos e status
    @Query("SELECT r.produto FROM RequisicaoCompra r WHERE r.status = :status")
    List<Produto> findProdutosByStatus(@Param("status") StatusRequisicao status);

}
