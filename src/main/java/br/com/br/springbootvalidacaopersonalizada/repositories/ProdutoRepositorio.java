package br.com.br.springbootvalidacaopersonalizada.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.br.springbootvalidacaopersonalizada.model.Produto;

@Repository
public interface ProdutoRepositorio extends JpaRepository<Produto, Integer> {
    
}
