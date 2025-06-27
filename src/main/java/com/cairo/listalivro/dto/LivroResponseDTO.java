package com.cairo.listalivro.dto;
import com.cairo.listalivro.model.Livros;
import com.cairo.listalivro.model.Status;

public record LivroResponseDTO(Long id, String nome, String autor, String imagem, Status status) {
    public LivroResponseDTO(Livros livros){
        this(livros.getId(), livros.getNome(), livros.getAutor(), livros.getImagem(), livros.getStatus());
    }
}
