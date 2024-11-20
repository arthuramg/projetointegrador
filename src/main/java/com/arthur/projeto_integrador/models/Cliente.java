package com.arthur.projeto_integrador.models;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // -> define que o DB irá criar o ID de acordo
    @Column(nullable = false) //não pode ser null
    private Long id;

    private String nome;
    private int idade;
    @Column(unique = true)
    private String email;

    public Cliente() {
    }

    public Cliente(String email, Long id, int idade, String nome) {
        this.email = email;
        this.id = id;
        this.idade = idade;
        this.nome = nome;
    }

    public Long getId(){ return id; }
    public void setId(Long id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getIdade(){ return idade; }
    public void setIdade(int idade){
        this.idade = idade;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

}
