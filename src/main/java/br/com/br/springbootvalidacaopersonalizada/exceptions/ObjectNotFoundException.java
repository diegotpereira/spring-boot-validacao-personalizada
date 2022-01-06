package br.com.br.springbootvalidacaopersonalizada.exceptions;

// Primeiramente vamos criar uma exception personalizada dentro de um 
// subpacote exceptions para tratar erro de object not found:
public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;
    
    public ObjectNotFoundException(String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }
}
