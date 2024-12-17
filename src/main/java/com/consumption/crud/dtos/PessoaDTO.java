package com.consumption.crud.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record PessoaDTO(
        @NotBlank
        @Size(min = 2, max = 50, message = "Nome não pode ser vazio!")
        String nome,

        String description,

        @NotBlank(message = "A senha não pode ser vazia")
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres")
        String senha
) {}