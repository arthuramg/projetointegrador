package com.arthur.projeto_integrador.resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ForncedorResource {

    @JsonProperty("id_fornecedor")
    private Long idFornecedor;
    @JsonProperty("nome_empresa")
    private String razaoSocial;
    @JsonProperty("cnpj")
    private int cnpj;
    @JsonProperty("endereco")
    private String endereco;
    @JsonProperty("telefone:")
    private int telefone;
    @JsonProperty("email")
    private String email;

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Long getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(Long idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public ForncedorResource(int cnpj, String email, String endereco, Long idFornecedor, String razaoSocial, int telefone) {
        this.cnpj = cnpj;
        this.email = email;
        this.endereco = endereco;
        this.idFornecedor = idFornecedor;
        this.razaoSocial = razaoSocial;
        this.telefone = telefone;
    }
}
