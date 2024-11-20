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
    public Iterable<Produto> listarProdutos(){
        return produtoRepository.findAll();
    }

    public ResponseEntity<?> cadastrarProduto(Produto produto, String acao){
        Map<String, Boolean> validacoes = Map.of( //mapeando os erros para poder identificar na criação
                "O nome do produto é obrigatório", produto.getNomeProduto().equals(""),
                "A quantidade do produto é obrigatória", produto.getQuantidade().equals(""),
                "O preço do produto não pode ser igual a zero", produto.getPrecoProduto().isNaN(),
                "O tipo do produto é obrigatório", produto.getTipoProduto().equals("")
        );

        for (Map.Entry<String, Boolean> validacao : validacoes.entrySet()) {
            if (validacao.getValue()) {
                respostaServer.setMensagem(validacao.getKey());
                return new ResponseEntity<>(respostaServer, HttpStatus.BAD_REQUEST);
            }
        }
        HttpStatus status = acao.equals("cadastrar") ? HttpStatus.CREATED : HttpStatus.OK;
        return new ResponseEntity<>(produtoRepository.save(produto), status);

    }
}