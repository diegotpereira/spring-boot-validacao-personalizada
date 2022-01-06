package br.com.br.springbootvalidacaopersonalizada.resources;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.br.springbootvalidacaopersonalizada.dto.ProdutoDTO;
import br.com.br.springbootvalidacaopersonalizada.model.Produto;
import br.com.br.springbootvalidacaopersonalizada.services.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoRecurso {

    @Autowired
    private ProdutoService service;

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable(value="id") String id) {
        ModelMapper modelMapper = new ModelMapper();

        Produto produto = service.findById(Integer.parseInt((id)));

        ProdutoDTO produtoDTO = modelMapper.map(produto, ProdutoDTO.class);

        return ResponseEntity.ok().body(produtoDTO);
    }
    
    @GetMapping("/test")
    public List<Produto> test() {

        BigDecimal preco = new BigDecimal(4.5);
        Produto mouse = new Produto(1 , "Mouse", preco);

        List<Produto> lista = new ArrayList<Produto>();
        lista.add(mouse);

        return lista;
    }
}
