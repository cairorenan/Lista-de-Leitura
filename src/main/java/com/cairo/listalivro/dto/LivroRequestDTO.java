package com.cairo.listalivro.dto;

import com.cairo.listalivro.model.Status;

public record LivroRequestDTO (String nome, String autor, String imagem, Status status){

}
