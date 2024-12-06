package com.consumption.crud.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class PessoaDTO {
    @NotBlank
    @Size(min = 2, max = 50, message = "nome nao pode ser vazio!")
    private String nome;
    private String description;
    @NotBlank(message = "A senha não pode ser vazia")
    @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
    private String senha;

}

public String getNome() {
    return nome;
}

public void setNome(String nome) {
    this.nome = nome;
}
