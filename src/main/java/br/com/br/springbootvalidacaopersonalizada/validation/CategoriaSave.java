package br.com.br.springbootvalidacaopersonalizada.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

import javax.validation.*;
import java.lang.annotation.*;

@Constraint(validatedBy = CategoriaSaveValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface CategoriaSave {
    String message()  default "Erro validação";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
