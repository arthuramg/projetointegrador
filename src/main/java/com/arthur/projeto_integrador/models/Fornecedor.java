package com.arthur.projeto_integrador.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Fornecedor {

    @Id
    @Column(nullable = false)
    private Long idFornecedor;
    private String razaoSocial;
    private int cnpj;
    private String endereco;
    private int telefone;
    private String email;

    public Fornecedor(int cnpj, String email, String endereco, Long idFornecedor, String razaoSocial, int telefone) {
        this.cnpj = cnpj;
        this.email = email;
        this.endereco = endereco;
        this.idFornecedor = idFornecedor;
        this.razaoSocial = razaoSocial;
        this.telefone = telefone;
    }

    public Long getIdForncedor(){
        return idFornecedor;
    }
    public void setIdFornecedor(Long idFornecedor){
        this.idFornecedor = idFornecedor;
    }
    public String getRazaoSocial(){
        return razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial){
        this.razaoSocial = razaoSocial;
    }
    public  int getCnpj(){
        return cnpj;
    }
    public void setCnpj(int cnpj){
        this.cnpj = cnpj;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public int getTelefone(){
        return telefone;
    }
    public void setTelefone(int telefone){
        this.telefone = telefone;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
