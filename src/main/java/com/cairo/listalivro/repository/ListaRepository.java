package com.cairo.listalivro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cairo.listalivro.model.Livros;

public interface ListaRepository extends JpaRepository<Livros, Long>{

}
