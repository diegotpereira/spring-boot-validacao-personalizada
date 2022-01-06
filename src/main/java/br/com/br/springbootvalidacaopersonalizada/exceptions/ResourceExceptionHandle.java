package br.com.br.springbootvalidacaopersonalizada.exceptions;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

// vamos criar uma classe para capturar exceptions do tipo ObjectNotFoundException e 
// dá um tratamento diferenciado. 
// Nesse caso escolhemos retornar código 404 para esse tipo de exception 
// ObjectNotFoundException

@ControllerAdvice
public class ResourceExceptionHandle {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e,
    HttpServletRequest request) {

        StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(),  e.getMessage(), System.currentTimeMillis());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e,
                                                    HttpServletRequest  request) {

        ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Erro na Validação", System.currentTimeMillis());

        for(FieldError field : e.getBindingResult().getFieldErrors()) {
            err.addError(field.getField(), field.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
