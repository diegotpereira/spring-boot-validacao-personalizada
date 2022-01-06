package br.com.br.springbootvalidacaopersonalizada.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.br.springbootvalidacaopersonalizada.model.Produto;
import br.com.br.springbootvalidacaopersonalizada.repositories.ProdutoRepositorio;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepositorio repo;

    public Produto findById(Integer id){
        Optional<Produto> obj = repo.findById(id);

        return obj.orElse(null);
    }
}
