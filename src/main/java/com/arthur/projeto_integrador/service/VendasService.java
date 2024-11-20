package com.arthur.projeto_integrador.services;

import com.arthur.projeto_integrador.models.Vendas;
import com.arthur.projeto_integrador.repositorios.VendasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendasService {

    @Autowired
    private VendasRepository vendasRepository;

    public List<Vendas> listarTodas() {
        return vendasRepository.findAll();
    }

    public Optional<Vendas> buscarPorId(Long id) {
        return vendasRepository.findById(id);
    }

    public  salvarVenda(Vendas venda) {
        return vendasRepository.save(venda);
    }

    public Vendas atualizarVenda(Long id, Vendas vendaAtualizada) {
        Optional<Vendas> vendaExistente = vendasRepository.findById(id);

        if (vendaExistente.isPresent()) {
            Vendas venda = vendaExistente.get();
            venda.setNotaFiscal(vendaAtualizada.getNotaFiscal());
            venda.setCliente(vendaAtualizada.getCliente());
            venda.setNome(vendaAtualizada.getNome());
            venda.setQtdItens(vendaAtualizada.getQtdItens());
            venda.setProduto(vendaAtualizada.getProduto());
            venda.setValorTotal(vendaAtualizada.getValorTotal());
            venda.setData(vendaAtualizada.getData());
            return vendasRepository.save(venda);
        }

        throw new RuntimeException("Venda não encontrada.");
    }

    public void excluirVenda(Long id) {
        if (vendasRepository.existsById(id)) {
            vendasRepository.deleteById(id);
        } else {
            throw new RuntimeException("Venda não encontrada.");
        }
    }
}
