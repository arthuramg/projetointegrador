package com.arthur.projeto_integrador.service;

import com.arthur.projeto_integrador.models.Produto;
import com.arthur.projeto_integrador.models.RespostaServer;
import com.arthur.projeto_integrador.repositorios.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private RespostaServer respostaServer;

    public Iterable<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    public ResponseEntity<?> cadastrarProduto(Produto produto, String acao) {
        // Validações dos campos obrigatórios
        Map<String, Boolean> validacoes = Map.of(
                "O nome do produto é obrigatório", produto.getNomeProduto() == null || produto.getNomeProduto().isBlank(),
                "A quantidade do produto é obrigatória", produto.getQuantidade() <= 0,
                "O preço do produto não pode ser igual a zero", produto.getPrecoProduto() <= 0,
                "O tipo do produto é obrigatório", produto.getTipoProduto() == null || produto.getTipoProduto().isBlank()
        );

        // Verifica se há validações inválidas e retorna a primeira mensagem de erro
        for (Map.Entry<String, Boolean> validacao : validacoes.entrySet()) {
            if (validacao.getValue()) {
                respostaServer.setMensagem(validacao.getKey());
                return new ResponseEntity<>(respostaServer, HttpStatus.BAD_REQUEST);
            }
        }

        // Define o status da resposta com base na ação (cadastrar ou atualizar)
        HttpStatus status = "cadastrar".equalsIgnoreCase(acao) ? HttpStatus.CREATED : HttpStatus.OK;
        Produto produtoSalvo = produtoRepository.save(produto);

        respostaServer.setMensagem("Produto " + (status == HttpStatus.CREATED ? "cadastrado" : "atualizado") + " com sucesso.");
        respostaServer.setObjeto(produtoSalvo);
        return new ResponseEntity<>(respostaServer, status);
    }
}