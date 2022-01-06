package br.com.br.springbootvalidacaopersonalizada.exceptions;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

public class ValidationError extends StandardError{

    private static final long serialVersionUID = 1L;

    @Getter
    private List<FieldMessage> errors = new ArrayList<FieldMessage>();

    public ValidationError(Integer status, String msg, Long timeStamp) {
        super(status, msg, timeStamp);
        
    }
    
    public void addError(String fieldName, String message) {
        
        this.errors.add(new FieldMessage(fieldName, message));
    }
}
