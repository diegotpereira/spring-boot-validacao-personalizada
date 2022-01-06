package br.com.br.springbootvalidacaopersonalizada.dto;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class ProdutoDTO {

    private Integer id;

    private String nome;

    private BigDecimal preco;
    
}
