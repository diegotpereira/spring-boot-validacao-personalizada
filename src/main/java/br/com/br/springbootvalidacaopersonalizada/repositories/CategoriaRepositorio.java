package br.com.br.springbootvalidacaopersonalizada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.br.springbootvalidacaopersonalizada.model.Categoria;

@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Integer>{
    
}
