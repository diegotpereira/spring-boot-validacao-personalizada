package br.com.br.springbootvalidacaopersonalizada.resources;

import java.net.URI;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.br.springbootvalidacaopersonalizada.dto.CategoriaDTO;
import br.com.br.springbootvalidacaopersonalizada.exceptions.ObjectNotFoundException;
import br.com.br.springbootvalidacaopersonalizada.model.Categoria;
import br.com.br.springbootvalidacaopersonalizada.services.CategoriaService;
// import javax.validation.Valid;

@RestController
@RequestMapping("/categoria")
public class CategoriaRecurso {
    
    @Autowired
    private CategoriaService service;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable(value = "id") String id){

        ModelMapper modelMapper = new ModelMapper();
        Categoria categoria = service.findById(Integer.parseInt(id));

        if (categoria == null) {
            throw new ObjectNotFoundException("Objeto " + Categoria.class.getName() + " não encontrada! id " + id);
        }

        CategoriaDTO categoriaDTO = modelMapper.map(categoria, CategoriaDTO.class);

        return ResponseEntity.ok().body(categoriaDTO);
    }

    @PostMapping()
    public ResponseEntity<Void> insert(@RequestBody Categoria obj) {
        obj = this.service.insert(obj);
        URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest().path("/{id}")
        .buildAndExpand(obj.getId())
        .toUri();

        return ResponseEntity.created(uri).build();
    }
    // @PostMapping()
	// public ResponseEntity<Void> insert(@RequestBody CategoriaDTO dto){
		
	// 	ModelMapper modelMapper = new ModelMapper();
	// 	Categoria obj = modelMapper.map(dto,Categoria.class);
		
	// 	obj = this.service.insert(obj);
	// 	URI uri = ServletUriComponentsBuilder
	// 			  .fromCurrentRequest().path("/{id}")
	// 			  .buildAndExpand(obj.getId())
	// 			  .toUri();
	// 	return ResponseEntity.created(uri).build();
	// }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody CategoriaDTO dto, 
                                       @PathVariable(value = "id") Integer id) {

        // framework que realiza o mapeamento de modelos
        ModelMapper modelMapper = new ModelMapper();
        Categoria obj = modelMapper.map(dto, Categoria.class);
        obj.setId(id);
        obj = this.service.update(obj);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value="id")Integer id) {
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
