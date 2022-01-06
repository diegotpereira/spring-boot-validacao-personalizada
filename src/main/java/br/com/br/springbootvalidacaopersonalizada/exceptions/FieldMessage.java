package br.com.br.springbootvalidacaopersonalizada.exceptions;

import java.io.Serializable;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldMessage implements Serializable{
    
    private static final long serialVersionUID = 1L;

    private String fieldName;
    private String message;
}
