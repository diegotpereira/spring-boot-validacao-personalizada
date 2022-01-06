package br.com.br.springbootvalidacaopersonalizada.dto;

import javax.validation.constraints.*;

import br.com.br.springbootvalidacaopersonalizada.validation.CategoriaSave;
import lombok.Data;

@Data
@CategoriaSave
public class CategoriaDTO {
    
    Integer id;

    @NotNull
    @Size(min = 2, max = 30)
    String nome;
}
