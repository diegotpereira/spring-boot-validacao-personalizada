package br.com.br.springbootvalidacaopersonalizada.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.br.springbootvalidacaopersonalizada.exceptions.ObjectNotFoundException;
import br.com.br.springbootvalidacaopersonalizada.model.Categoria;
import br.com.br.springbootvalidacaopersonalizada.repositories.CategoriaRepositorio;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepositorio repositorio;
    
    public Categoria findById(Integer id){
        Optional<Categoria> obj = this.repositorio.findById(id);

        return obj.orElse(null);
    }

    public Categoria insert(Categoria obj) {
        obj.setId(null);

        return this.repositorio.save(obj);
    }

    public Categoria update(Categoria obj) {
        if (this.findById(obj.getId()) == null) {
            throw new ObjectNotFoundException("Objeto " + Categoria.class.getName() + " não encontrado! ID" + obj.getId());
        }

        return this.repositorio.save(obj);
    }

    public void delete(Integer id) {
        if (this.findById(id) == null) {
            throw new ObjectNotFoundException("Objeto " + Categoria.class.getName() + " não encontrado! ID" + id);
        }
        repositorio.deleteById(id);
    }
}
