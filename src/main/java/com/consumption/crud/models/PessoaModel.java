package com.consumption.crud.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "pessoas")

@Setter
public class PessoaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String nome;
    private String description;
    private String senha;


//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }

}




