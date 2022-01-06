package br.com.br.springbootvalidacaopersonalizada.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import br.com.br.springbootvalidacaopersonalizada.dto.CategoriaDTO;
import br.com.br.springbootvalidacaopersonalizada.exceptions.FieldMessage;

public class CategoriaSaveValidator implements ConstraintValidator<CategoriaSave, CategoriaDTO>{
    
    @Override
    public void initialize(CategoriaSave ann) {

    }

    @Override
    public boolean isValid(CategoriaDTO objDto, ConstraintValidatorContext context) {
        List<FieldMessage> erros = new ArrayList<>();

        if (objDto.getNome().equals("null")) {
            erros.add(new FieldMessage("nome", "não pode ser String null"));
        }

        for(FieldMessage e : erros){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
            .addConstraintViolation();
        }
        return erros.isEmpty();
    }
}
