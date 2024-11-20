package com.arthur.projeto_integrador.models;

import jakarta.persistence.*;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idFornecedor;
    private String razaoSocial;
    @Column(unique = true)
    private String cnpj;
    private String endereco;
    private String telefone;
    private String email;

    public Fornecedor(String cnpj, String email, String endereco, Long idFornecedor, String razaoSocial, String telefone) {
        this.cnpj = cnpj;
        this.email = email;
        this.endereco = endereco;
        this.razaoSocial = razaoSocial;
        this.telefone = telefone;
    }

    public Fornecedor() {}


    public Long getIdFornecedor(){
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
    public String getCnpj(){
        return cnpj;
    }
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getTelefone(){
        return telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
}
