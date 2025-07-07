package com.cairo.listalivro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cairo.listalivro.dto.LivroRequestDTO;
import com.cairo.listalivro.dto.LivroResponseDTO;
import com.cairo.listalivro.service.ListaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/")
public class ListaController {
    @Autowired
    private ListaService listaService;
    
    @GetMapping("/list")
    public List<LivroResponseDTO> ListarLivros(){
        return listaService.ListarLivros();
    }

    @GetMapping("/livro/{id}")
    public ResponseEntity<LivroResponseDTO> BuscarLivro(@PathVariable Long id){
        return listaService.BuscarLivro(id);
    }

    @PostMapping("/cadastrar")
    public void CadastrarLivro(@RequestBody LivroRequestDTO data){
        listaService.CadastrarLivro(data);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> DeletarLivro(@PathVariable Long id){
        return listaService.DeletarLivro(id);
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Void> EditarLivro(@PathVariable Long id, @Valid @RequestBody LivroRequestDTO data){
        return listaService.EditarLivro(id, data.nome(), data.autor(), data.imagem(), data.status());
    }
}
