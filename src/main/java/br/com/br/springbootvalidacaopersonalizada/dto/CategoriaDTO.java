package br.com.br.springbootvalidacaopersonalizada.dto;

import javax.validation.constraints.*;

import lombok.Data;

@Data
public class CategoriaDTO {
    
    Integer id;

    @NotNull
    @Size(min = 2, max = 30)
    String nome;
}
