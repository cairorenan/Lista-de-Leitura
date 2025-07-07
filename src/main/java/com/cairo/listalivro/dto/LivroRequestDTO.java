package com.cairo.listalivro.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import com.cairo.listalivro.model.Status;

public record LivroRequestDTO(
    @NotBlank String nome,
    @NotBlank String autor,
    @NotBlank String imagem,
    @NotNull Status status
) {}
