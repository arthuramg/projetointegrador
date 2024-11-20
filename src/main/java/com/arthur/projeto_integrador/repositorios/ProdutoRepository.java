package com.arthur.projeto_integrador.repositorios;

import com.arthur.projeto_integrador.models.Pedidos;
import com.arthur.projeto_integrador.models.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    //buscar produtos com quantidade abaixo do estoque mínimo
    @Query("SELECT p FROM Produto p WHERE p.quantidade < p.estoqueMin")
    List<Produto> findByQuantidadeLessThanEstoqueMin();

}
