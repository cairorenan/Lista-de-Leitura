package com.cairo.listalivro.model;

import com.cairo.listalivro.dto.LivroRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Livros")
@Table(name = "Livros")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Livros {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String autor;
    private String imagem;
    private Status status;

    public Livros(LivroRequestDTO data){
        this.nome = data.nome();
        this.autor = data.autor();
        this.imagem = data.imagem();
        this.status = data.status();
    }
}
