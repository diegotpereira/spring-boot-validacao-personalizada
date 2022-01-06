package br.com.br.springbootvalidacaopersonalizada.exceptions;

import java.io.Serializable;

import lombok.*;

@Data
@AllArgsConstructor
// Vamos criar um subpacote resources.exceptions e dentro dele a classe para armazenar 
// os dados da exception. 
// (Utilizeio o lombok para suprimir getters setters e o construtor com argumentos)
public class StandardError implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private Integer status;
    private String msg;
    private Long timeStamp;
    
}
