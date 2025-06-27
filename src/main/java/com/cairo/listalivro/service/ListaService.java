package com.cairo.listalivro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cairo.listalivro.dto.LivroRequestDTO;
import com.cairo.listalivro.dto.LivroResponseDTO;
import com.cairo.listalivro.model.Livros;
import com.cairo.listalivro.repository.ListaRepository;
import com.cairo.listalivro.model.Status;


@Service
public class ListaService {
    @Autowired
    private ListaRepository listaRepository;

    public List<LivroResponseDTO> ListarLivros(){
        List<LivroResponseDTO> livrosList = listaRepository.findAll().stream().map(LivroResponseDTO::new).toList();
        return livrosList;
    }

    public void CadastrarLivro(LivroRequestDTO data){
        Livros livroData = new Livros(data);
        listaRepository.save(livroData);
    }

    public ResponseEntity<LivroResponseDTO> BuscarLivro(Long id){
        Optional<Livros> livroBusca = listaRepository.findById(id);
        if(livroBusca.isPresent()){
            LivroResponseDTO response = new LivroResponseDTO(livroBusca.get());
            return ResponseEntity.ok(response);
        }else{return ResponseEntity.notFound().build();}
    }

    public ResponseEntity<Void> EditarLivro(Long id, String nome, String autor, String imagem, Status status){
        Optional<Livros> livroBusca = listaRepository.findById(id);
        if(livroBusca.isPresent()){
            Livros livro = livroBusca.get();
            livro.setNome(nome);
            livro.setAutor(autor);
            livro.setImagem(imagem);
            livro.setStatus(status);
            listaRepository.save(livro);
            return ResponseEntity.ok().build();
        }else{return ResponseEntity.notFound().build();}
    }

    public ResponseEntity<Void> DeletarLivro(Long id){
        Optional<Livros> livroBusca = listaRepository.findById(id);
        if(livroBusca.isPresent()){
            listaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }else{return ResponseEntity.notFound().build();}
    }

}
