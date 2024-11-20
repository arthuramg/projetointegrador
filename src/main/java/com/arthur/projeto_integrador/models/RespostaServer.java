package com.arthur.projeto_integrador.models;

import org.springframework.stereotype.Component;

@Component
public class RespostaServer {
    private String mensagem;
    private Object objeto;

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }

    public Object getObjeto() {
        return objeto;
    }

    public void setObjeto(Object objeto) {
        this.objeto = objeto;
    }

}
